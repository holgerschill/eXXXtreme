package org.eclipse.eXXXtreme.tutorial

import com.google.common.base.CaseFormat
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.util.List

class DBAccess {

	def static <E extends ITable> List<E> loadTable(Connection conn, Class<E> clazz) {
		val stmt = conn.createStatement()
		val resultSet = stmt.executeQuery('''SELECT * FROM PUBLIC.«clazz.toTableName»''')
		val List<E> result = newArrayList
		while (resultSet.next) {
			result += <E>createClassInstance(conn, resultSet, clazz)
		}
		result
	}
	
	def static String toTableName(Class<?> clazz) {
		clazz.simpleName.toSQLName
	}

	def static String toSQLName(String javaName) {
		val result = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, javaName)
		return result
	}

	def static <E> E createClassInstance(Connection conn, Class<E> clazz, String PK_Column_Name, Object keyValue) {
		if (keyValue === null) {
			return null;
		}
		val stmt = conn.createStatement()
		val resultSet = stmt.executeQuery(
			'''SELECT * FROM PUBLIC.«clazz.toTableName» WHERE «PK_Column_Name» = '«keyValue»' ''')
		resultSet.next
		createClassInstance(conn, resultSet, clazz)
	}

	def static <E> E createClassInstance(Connection conn, ResultSet resultSet, Class<E> clazz) {
		val metaData = conn.metaData
		val foreignKeys = metaData.getImportedKeys(null, null, clazz.toTableName)
		val fkMap = <String, String>newHashMap()
		while (foreignKeys.next) {
			val COLUMN_NAME = foreignKeys.getString("FKCOLUMN_NAME")
			val PK_COLUMN = foreignKeys.getString("PKCOLUMN_NAME")
			fkMap.put(COLUMN_NAME, PK_COLUMN)
		}
		clazz.newInstance => [
			val declaredFields = clazz.declaredFields
			for (f : declaredFields) {
				f.accessible = true
				val col = f.name.toSQLName
				val value = resultSet.getObject(col)
				val pk_column = fkMap.get(col)
				if (pk_column == null) {
					f.set(it, value)
				} else {
					f.set(it, createClassInstance(conn, f.type, pk_column, value))
				}
			}
		]

	}

	def static Connection getConnection(String dbPath) {
		DriverManager.getConnection("jdbc:h2:" + dbPath, "sa", "")
	}

}

interface ITable {
}