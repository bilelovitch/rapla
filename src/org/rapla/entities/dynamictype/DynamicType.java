/*--------------------------------------------------------------------------*
 | Copyright (C) 2006 Christopher Kohlhaas                                  |
 |                                                                          |
 | This program is free software; you can redistribute it and/or modify     |
 | it under the terms of the GNU General Public License as published by the |
 | Free Software Foundation. A copy of the license has been included with   |
 | these distribution in the COPYING file, if not go to www.fsf.org         |
 |                                                                          |
 | As a special exception, you are granted the permissions to link this     |
 | program with every library, which license fulfills the Open Source       |
 | Definition as published by the Open Source Initiative (OSI).             |
 *--------------------------------------------------------------------------*/
package org.rapla.entities.dynamictype;

import org.rapla.entities.Annotatable;
import org.rapla.entities.Entity;
import org.rapla.entities.MultiLanguageNamed;
import org.rapla.entities.RaplaType;

/** In rapla it is possible to dynamicly classify a reservation, resource or person with
    customized attributes. You can for example define a dynamicType called <em>room</em> with the
    attributes <em>name</em> and <em>seats</em> and classify all your room-resources as <em>room</em>.
 */
public interface DynamicType extends Entity<DynamicType>,MultiLanguageNamed,Annotatable
{
    final RaplaType<DynamicType> TYPE = new RaplaType<DynamicType>(DynamicType.class, "dynamictype");
    
    Attribute[] getAttributes();
    /** returns null if the attribute is not found */
    Attribute getAttribute(String key);
    void addAttribute(Attribute attribute);
    
    /** find an attribute in the dynamic type that equals the specified attribute This is usefull if you have the
     * persistant version of an attribute and want to discover the editable version in the working copy of a dynamic type */
    Attribute findAttribute(Attribute attribute);
    
    boolean hasAttribute(Attribute attribute);
    void removeAttribute(Attribute attribute);
    /** exchange the two attribute positions */
    void exchangeAttributes(int index1, int index2);
    void setElementKey(String elementKey);
    String getElementKey();
    /* creates a new classification and initializes it with the attribute defaults
     * @throws IllegalStateException when called from a non persistant instance of DynamicType */
    Classification newClassification();
    /* creates a new classification 
     * @throws IllegalStateException when called from a non persistant instance of DynamicType */
    Classification newClassification(boolean useDefaults);
    /* creates a new classification and tries to fill it with the values of the originalClassification.
    * @throws IllegalStateException when called from a non persistant instance of DynamicType */
    Classification newClassification(Classification originalClassification);
    /* @throws IllegalStateException when called from a non persistant instance of DynamicType */
    ClassificationFilter newClassificationFilter();
    
    final DynamicType[] DYNAMICTYPE_ARRAY = new DynamicType[0];
}




