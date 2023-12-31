package com.dons.krohn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "films")
public class Film extends AbstractEntity {

    private LocalDateTime uploadDate;
    private String title;
    private String description;
    private String url;
    private double length;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    @OneToMany(mappedBy = "film")
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Override
    public void setId(Long id) {
        super.setId(id);
    }
}
