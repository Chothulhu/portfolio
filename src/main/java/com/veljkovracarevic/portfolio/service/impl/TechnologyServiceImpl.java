package com.veljkovracarevic.portfolio.service.impl;

import com.veljkovracarevic.portfolio.dto.TechnologyDto;
import com.veljkovracarevic.portfolio.repository.TechnologyRepository;
import com.veljkovracarevic.portfolio.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;

public class TechnologyServiceImpl implements TechnologyService {

    private TechnologyRepository technologyRepository;

    @Autowired
    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public TechnologyDto createTechnology(TechnologyDto technologyDto) {
        return null;
    }
}
