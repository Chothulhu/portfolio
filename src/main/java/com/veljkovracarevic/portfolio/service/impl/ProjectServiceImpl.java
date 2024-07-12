package com.veljkovracarevic.portfolio.service.impl;

import com.veljkovracarevic.portfolio.dto.ProjectDto;
import com.veljkovracarevic.portfolio.exceptions.ProjectNotFoundException;
import com.veljkovracarevic.portfolio.models.Project;
import com.veljkovracarevic.portfolio.repository.ProjectRepository;
import com.veljkovracarevic.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        return null;
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(proj -> mapToDto(proj)).collect(Collectors.toList());
    }

    @Override
    public ProjectDto getProjectById(int id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project not found."));
        return mapToDto(project);
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto, int id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project not found."));

        project.setName(projectDto.getName());
        project.setLogoPath(projectDto.getLogoPath());
        project.setLink(projectDto.getLink());
        project.setDescription(projectDto.getDescription());

        Project updatedProject = projectRepository.save(project);
        return mapToDto(updatedProject);
    }

    @Override
    public void deleteProjectId(int id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project not found."));

        projectRepository.delete(project);
    }

    private ProjectDto mapToDto(Project project){
        ProjectDto projectDto = new ProjectDto();

        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        projectDto.setLogoPath(project.getLogoPath());
        projectDto.setLink(project.getLink());
        projectDto.setDescription(project.getDescription());

        return projectDto;
    }

    private Project mapToEntitiy (ProjectDto projectDto){
        Project project = new Project();

        project.setId(projectDto.getId());
        project.setName(projectDto.getName());
        project.setLogoPath(projectDto.getLogoPath());
        project.setLink(projectDto.getLink());
        project.setDescription(projectDto.getDescription());

        return project;
    }
}
