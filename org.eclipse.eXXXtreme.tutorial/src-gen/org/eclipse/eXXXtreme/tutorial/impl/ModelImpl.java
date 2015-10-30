/**
 */
package org.eclipse.eXXXtreme.tutorial.impl;

import java.util.Collection;

import org.eclipse.eXXXtreme.tutorial.Model;
import org.eclipse.eXXXtreme.tutorial.Query;
import org.eclipse.eXXXtreme.tutorial.TutorialPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.eXXXtreme.tutorial.impl.ModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.eXXXtreme.tutorial.impl.ModelImpl#getH2Path <em>H2 Path</em>}</li>
 *   <li>{@link org.eclipse.eXXXtreme.tutorial.impl.ModelImpl#getQueries <em>Queries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getH2Path() <em>H2 Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getH2Path()
   * @generated
   * @ordered
   */
  protected static final String H2_PATH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getH2Path() <em>H2 Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getH2Path()
   * @generated
   * @ordered
   */
  protected String h2Path = H2_PATH_EDEFAULT;

  /**
   * The cached value of the '{@link #getQueries() <em>Queries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQueries()
   * @generated
   * @ordered
   */
  protected EList<Query> queries;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TutorialPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TutorialPackage.MODEL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getH2Path()
  {
    return h2Path;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setH2Path(String newH2Path)
  {
    String oldH2Path = h2Path;
    h2Path = newH2Path;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TutorialPackage.MODEL__H2_PATH, oldH2Path, h2Path));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Query> getQueries()
  {
    if (queries == null)
    {
      queries = new EObjectContainmentEList<Query>(Query.class, this, TutorialPackage.MODEL__QUERIES);
    }
    return queries;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TutorialPackage.MODEL__QUERIES:
        return ((InternalEList<?>)getQueries()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TutorialPackage.MODEL__NAME:
        return getName();
      case TutorialPackage.MODEL__H2_PATH:
        return getH2Path();
      case TutorialPackage.MODEL__QUERIES:
        return getQueries();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TutorialPackage.MODEL__NAME:
        setName((String)newValue);
        return;
      case TutorialPackage.MODEL__H2_PATH:
        setH2Path((String)newValue);
        return;
      case TutorialPackage.MODEL__QUERIES:
        getQueries().clear();
        getQueries().addAll((Collection<? extends Query>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TutorialPackage.MODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TutorialPackage.MODEL__H2_PATH:
        setH2Path(H2_PATH_EDEFAULT);
        return;
      case TutorialPackage.MODEL__QUERIES:
        getQueries().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TutorialPackage.MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TutorialPackage.MODEL__H2_PATH:
        return H2_PATH_EDEFAULT == null ? h2Path != null : !H2_PATH_EDEFAULT.equals(h2Path);
      case TutorialPackage.MODEL__QUERIES:
        return queries != null && !queries.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", h2Path: ");
    result.append(h2Path);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
