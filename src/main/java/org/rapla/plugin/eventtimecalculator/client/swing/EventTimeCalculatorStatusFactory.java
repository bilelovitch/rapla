package org.rapla.plugin.eventtimecalculator.client.swing;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.rapla.RaplaResources;
import org.rapla.client.ReservationEdit;
import org.rapla.client.extensionpoints.AppointmentStatusFactory;
import org.rapla.client.swing.toolkit.RaplaWidget;
import org.rapla.facade.ClientFacade;
import org.rapla.framework.RaplaException;
import org.rapla.framework.RaplaLocale;
import org.rapla.framework.logger.Logger;
import org.rapla.inject.Extension;
import org.rapla.plugin.eventtimecalculator.EventTimeCalculatorFactory;
import org.rapla.plugin.eventtimecalculator.EventTimeCalculatorResources;

@Extension(provides = AppointmentStatusFactory.class, id="eventtimecalculator")
@Singleton
public class EventTimeCalculatorStatusFactory<T> implements AppointmentStatusFactory<T> {
    private final EventTimeCalculatorFactory factory;
    private final EventTimeCalculatorResources resources;
    private final ClientFacade facade;
    private final RaplaResources i18n;
    private final RaplaLocale raplaLocale;
    private final Logger logger;

    @Inject
    public EventTimeCalculatorStatusFactory(ClientFacade facade, RaplaResources i18n, RaplaLocale raplaLocale, Logger logger, EventTimeCalculatorFactory factory, EventTimeCalculatorResources resources)
    {
        this.facade = facade;
        this.i18n = i18n;
        this.raplaLocale = raplaLocale;
        this.logger = logger;
        this.factory = factory;
        this.resources = resources;
    }
	public RaplaWidget<T> createStatus(ReservationEdit reservationEdit) throws RaplaException {
        return new EventTimeCalculatorStatusWidget(facade, i18n, raplaLocale, logger, reservationEdit,factory, resources);
    }
}
