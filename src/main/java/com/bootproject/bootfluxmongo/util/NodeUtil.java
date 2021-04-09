package com.bootproject.bootfluxmongo.util;

import com.bootproject.bootfluxmongo.dto.DTOEntity;
import com.bootproject.bootfluxmongo.model.AbstractBaseEntity;
import com.bootproject.bootfluxmongo.model.NodeDesc;
import com.bootproject.bootfluxmongo.model.NodeRoot;

public class NodeUtil {

    public static AbstractBaseEntity getNode(DTOEntity dtoEntity) {
        if (dtoEntity.getDescription() == null) {
            return new NodeRoot(dtoEntity.getId(), dtoEntity.getName());
        }
        return new NodeDesc(dtoEntity.getId(), dtoEntity.getName(), dtoEntity.getDescription());
    }
}
