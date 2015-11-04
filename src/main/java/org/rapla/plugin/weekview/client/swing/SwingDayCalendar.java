
/*--------------------------------------------------------------------------*
 | Copyright (C) 2006  Christopher Kohlhaas                                 |
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

package org.rapla.plugin.weekview.client.swing;

import java.awt.Component;
import java.util.Calendar;
import java.util.Set;

import javax.inject.Provider;

import org.rapla.RaplaResources;
import org.rapla.client.ReservationController;
import org.rapla.client.extensionpoints.ObjectMenuFactory;
import org.rapla.client.internal.RaplaClipboard;
import org.rapla.client.swing.InfoFactory;
import org.rapla.client.swing.MenuFactory;
import org.rapla.client.swing.images.RaplaImages;
import org.rapla.client.swing.toolkit.DialogUI;
import org.rapla.client.swing.toolkit.DialogUI.DialogUiFactory;
import org.rapla.components.calendar.DateRenderer;
import org.rapla.components.iolayer.IOInterface;
import org.rapla.entities.domain.permission.PermissionController;
import org.rapla.facade.CalendarModel;
import org.rapla.facade.CalendarOptions;
import org.rapla.facade.CalendarSelectionModel;
import org.rapla.facade.ClientFacade;
import org.rapla.framework.RaplaException;
import org.rapla.framework.RaplaLocale;
import org.rapla.framework.logger.Logger;

public class SwingDayCalendar extends SwingWeekCalendar
{
    public SwingDayCalendar(ClientFacade facade, RaplaResources i18n, RaplaLocale raplaLocale, Logger logger, CalendarModel model, boolean editable,
            final Set<ObjectMenuFactory> objectMenuFactories, MenuFactory menuFactory, Provider<DateRenderer> dateRendererProvider,
            CalendarSelectionModel calendarSelectionModel, RaplaClipboard clipboard, ReservationController reservationController,
            InfoFactory<Component, DialogUI> infoFactory, RaplaImages raplaImages, DateRenderer dateRenderer, DialogUiFactory dialogUiFactory,
            PermissionController permissionController, IOInterface ioInterface) throws RaplaException
    {
        super(facade, i18n, raplaLocale, logger, model, editable, objectMenuFactories, menuFactory, dateRendererProvider, calendarSelectionModel, clipboard,
                reservationController, infoFactory, raplaImages, dateRenderer, dialogUiFactory, permissionController, ioInterface);
    }

    @Override
    protected int getDays(CalendarOptions calendarOptions)
    {
        return 1;
    }

    public int getIncrementSize()
    {
        return Calendar.DAY_OF_YEAR;
    }

}
