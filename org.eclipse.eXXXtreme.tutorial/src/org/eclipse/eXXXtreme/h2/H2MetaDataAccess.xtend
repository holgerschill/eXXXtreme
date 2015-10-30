package org.eclipse.eXXXtreme.h2

import com.google.common.base.CaseFormat
import java.math.BigDecimal
import java.sql.DriverManager
import java.util.Date
import java.util.List
import org.eclipse.eXXXtreme.tutorial.Model
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.XtextResourceSet
import org.h2.Driver
import java.io.File

class H2MetaDataAccess {

	/**
	 * Read the table information from the database at the given absolute location
	 */
	def List<TableInfo> getTableInfos(String dbPath) {
		if (!new File(dbPath + ".mv.db").exists) {
			return emptyList
		}
		Driver.simpleName // initialize driver
		val List<TableInfo> tables = newArrayList
		val conn = DriverManager.getConnection("jdbc:h2:" + dbPath, "sa", "")
		try {
			val metadata = conn.metaData
			val rs = metadata.getTables(null, "PUBLIC", "%", null)
			while (rs.next) {
				val tableName = rs.getString("TABLE_NAME")
				tables += new TableInfo => [
					name = tableName.toCamelCase
					columns = newArrayList
					val foreignKeys = metadata.getImportedKeys(null, null, tableName)
					val fkToTypeName = newHashMap
					while (foreignKeys.next) {
						val fieldName = foreignKeys.getString("FKCOLUMN_NAME").toCamelCase
						val typeName = foreignKeys.getString("PKTABLE_NAME").toCamelCase
						fkToTypeName.put(fieldName, typeName)
					}
					val resultSet = metadata.getColumns(null, null, tableName, null)
					while (resultSet.next) {
						val fieldName = resultSet.getString("COLUMN_NAME").toCamelCase
						columns += new ColumnInfo => [
							name = fieldName
							typeName = fkToTypeName.get(fieldName) ?: switch (resultSet.getString("TYPE_NAME")) {
								case "VARCHAR": String.typeName
								case "DECIMAL": BigDecimal.typeName
								case "DATE": Date.typeName
								default: String.typeName
							}
						]
					}
				]
			}
		} finally {
			conn.close
		}

		tables
	}

	def toCamelCase(String name) {
		CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name)
	}

	def String getProjectPath(Model model) {
		val xtextResourceSet = model.eResource.resourceSet as XtextResourceSet
		val javaProject = xtextResourceSet.classpathURIContext as IJavaProject
		if (javaProject !== null) {
			val project = javaProject.project
			return project.locationURI.path
		} else {
			return "./"
		}
	}
}

class TableInfo {
	@Accessors
	String name
	@Accessors
	List<ColumnInfo> columns
}

class ColumnInfo {
	@Accessors
	String name
	@Accessors
	String typeName
}