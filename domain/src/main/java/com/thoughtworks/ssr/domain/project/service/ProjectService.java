package com.thoughtworks.ssr.domain.project.service;

import com.thoughtworks.ssr.domain.project.exception.ProjectException;
import com.thoughtworks.ssr.domain.project.model.Project;
import com.thoughtworks.ssr.domain.project.query.ProjectQuery;
import com.thoughtworks.ssr.domain.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Project create(Project project) {
        return projectRepository.create(project);
    }

    public Project update(Project project) {
        return projectRepository.update(project);
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).orElseThrow(ProjectException::notFound);
    }

    public Page<Project> pageProjects(ProjectQuery projectQuery, Pageable pageable) {
        return projectRepository.pageProjects(projectQuery, pageable);
    }

    public void deleteById(Long id) {
        try {
            projectRepository.deleteById(id);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw ProjectException.notFound();
        }
    }
}
