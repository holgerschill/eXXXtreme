/**
 */
package org.eclipse.eXXXtreme.tutorial;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.eXXXtreme.tutorial.Model#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.eXXXtreme.tutorial.Model#getH2Path <em>H2 Path</em>}</li>
 * </ul>
 *
 * @see org.eclipse.eXXXtreme.tutorial.TutorialPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.eXXXtreme.tutorial.TutorialPackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.eXXXtreme.tutorial.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>H2 Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>H2 Path</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>H2 Path</em>' attribute.
   * @see #setH2Path(String)
   * @see org.eclipse.eXXXtreme.tutorial.TutorialPackage#getModel_H2Path()
   * @model
   * @generated
   */
  String getH2Path();

  /**
   * Sets the value of the '{@link org.eclipse.eXXXtreme.tutorial.Model#getH2Path <em>H2 Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>H2 Path</em>' attribute.
   * @see #getH2Path()
   * @generated
   */
  void setH2Path(String value);

} // Model
