package com.thoughtworks.ssr.infrastructure.persistence.usecases.entity;

import com.thoughtworks.ssr.infrastructure.persistence.common.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity(name = "use_case")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UseCaseEntity extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Long securityToolId;

    private String scriptPath;
}
