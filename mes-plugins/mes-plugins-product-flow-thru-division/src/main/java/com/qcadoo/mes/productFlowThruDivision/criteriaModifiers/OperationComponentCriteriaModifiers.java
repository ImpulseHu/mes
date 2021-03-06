/**
 * ***************************************************************************
 * Copyright (c) 2010 Qcadoo Limited
 * Project: Qcadoo Framework
 * Version: 1.4
 *
 * This file is part of Qcadoo.
 *
 * Qcadoo is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation; either version 3 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * ***************************************************************************
 */
package com.qcadoo.mes.productFlowThruDivision.criteriaModifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcadoo.mes.technologies.constants.TechnologiesConstants;
import com.qcadoo.mes.technologies.constants.TechnologyOperationComponentFields;
import com.qcadoo.model.api.DataDefinitionService;
import com.qcadoo.model.api.search.SearchCriteriaBuilder;
import com.qcadoo.model.api.search.SearchRestrictions;
import com.qcadoo.view.api.components.lookup.FilterValueHolder;

@Service
public class OperationComponentCriteriaModifiers {

    public static final String TECHNOLOGY_PARAMETER = "technologyID";

    @Autowired
    private DataDefinitionService dataDefinitionService;

    public void showTOCsForTechnology(final SearchCriteriaBuilder scb, final FilterValueHolder filterValue) {
        Long technologyId = null;
        if (!filterValue.has(TECHNOLOGY_PARAMETER)) {
            technologyId = 0L;
        } else {
            technologyId = filterValue.getLong(TECHNOLOGY_PARAMETER);
        }
        scb.add(SearchRestrictions
                .belongsTo(TechnologyOperationComponentFields.TECHNOLOGY,
                        dataDefinitionService.get(TechnologiesConstants.PLUGIN_IDENTIFIER, TechnologiesConstants.MODEL_TECHNOLOGY)
                                .get(technologyId)));
    }
}
