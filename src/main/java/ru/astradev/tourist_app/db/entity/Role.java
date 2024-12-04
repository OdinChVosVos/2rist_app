package ru.astradev.tourist_app.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

public enum Role {
    USER,
    ADMIN
}