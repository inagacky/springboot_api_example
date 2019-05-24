package com.inagacky.api_sample_app.presentation.mapper;

import org.modelmapper.ModelMapper;

public abstract class BaseMapper
{

    private static ModelMapper modelMapper;

    /**
     *
     * @return
     */
    protected static ModelMapper getModelMapper() {

        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }
}
