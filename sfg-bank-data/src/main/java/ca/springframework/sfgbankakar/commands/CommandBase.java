package ca.springframework.sfgbankakar.commands;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class CommandBase {
    private Long id;
}
