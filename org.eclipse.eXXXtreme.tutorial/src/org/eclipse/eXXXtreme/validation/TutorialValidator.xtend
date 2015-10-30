/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package org.eclipse.eXXXtreme.validation

import com.google.inject.Inject
import java.io.File
import org.eclipse.eXXXtreme.h2.H2MetaDataAccess
import org.eclipse.eXXXtreme.tutorial.Model
import org.eclipse.eXXXtreme.tutorial.TutorialPackage
import org.eclipse.xtext.validation.Check

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class TutorialValidator extends AbstractTutorialValidator {
	
	@Inject
	extension H2MetaDataAccess 
	
	@Check
	def checkIfH2FileExists(Model model){
		val h2Path = model.h2Path
		if(h2Path.startsWith("/")){
			error("Path should be relativ to project like 'db/test'.",TutorialPackage.Literals.MODEL__H2_PATH)
		}
		val file = new File(model.getProjectPath +  "/" + h2Path + ".mv.db")
		if(!file.exists){
			error("File does not exist!", TutorialPackage.Literals.MODEL__H2_PATH)
		}
	}
	
}
