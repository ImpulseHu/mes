package com.qcadoo.mes.productionCounting.listeners;

import org.springframework.stereotype.Service;

import com.qcadoo.mes.productionCounting.constants.AnomalyFields;
import com.qcadoo.model.api.Entity;
import com.qcadoo.view.api.ComponentState;
import com.qcadoo.view.api.ViewDefinitionState;
import com.qcadoo.view.api.components.FormComponent;

@Service
public class AnomalyDetailsListeners {

    private static final String L_FORM = "form";

    public void completeWithoutIssue(final ViewDefinitionState view, final ComponentState state, final String[] args) {
        FormComponent form = (FormComponent) view.getComponentByReference(L_FORM);

        Entity anomaly = form.getEntity();

        if (anomaly.getId() == null) {
            return;
        }

        anomaly.setField(AnomalyFields.STATE, AnomalyFields.State.COMPLETED);
        anomaly.setField(AnomalyFields.ISSUED, false);
        anomaly.getDataDefinition().save(anomaly);

        state.performEvent(view, "reset", new String[0]);
    }
}
