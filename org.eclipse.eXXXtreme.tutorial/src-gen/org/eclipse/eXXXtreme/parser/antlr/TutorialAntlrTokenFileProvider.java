/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package org.eclipse.eXXXtreme.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class TutorialAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/eclipse/eXXXtreme/parser/antlr/internal/InternalTutorial.tokens");
	}
}
