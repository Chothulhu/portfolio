package com.veljkovracarevic.portfolio.service;

import com.veljkovracarevic.portfolio.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    ProjectDto createProject(ProjectDto projectDto);

    List<ProjectDto> getAllProjects();
    ProjectDto getProjectById(int id);
    ProjectDto updateProject(ProjectDto projectDto, int id);
    void deleteProjectId(int id);
}
