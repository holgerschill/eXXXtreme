/**
 */
package org.eclipse.eXXXtreme.tutorial;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.eXXXtreme.tutorial.TutorialFactory
 * @model kind="package"
 * @generated
 */
public interface TutorialPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "tutorial";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/eXXXtreme/Tutorial";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "tutorial";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TutorialPackage eINSTANCE = org.eclipse.eXXXtreme.tutorial.impl.TutorialPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.eXXXtreme.tutorial.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.eXXXtreme.tutorial.impl.ModelImpl
   * @see org.eclipse.eXXXtreme.tutorial.impl.TutorialPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>H2 Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__H2_PATH = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.eXXXtreme.tutorial.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.eXXXtreme.tutorial.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.eXXXtreme.tutorial.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.eXXXtreme.tutorial.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.eXXXtreme.tutorial.Model#getH2Path <em>H2 Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>H2 Path</em>'.
   * @see org.eclipse.eXXXtreme.tutorial.Model#getH2Path()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_H2Path();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TutorialFactory getTutorialFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.eXXXtreme.tutorial.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.eXXXtreme.tutorial.impl.ModelImpl
     * @see org.eclipse.eXXXtreme.tutorial.impl.TutorialPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '<em><b>H2 Path</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__H2_PATH = eINSTANCE.getModel_H2Path();

  }

} //TutorialPackage
