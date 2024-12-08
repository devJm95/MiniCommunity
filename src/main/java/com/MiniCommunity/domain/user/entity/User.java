package com.MiniCommunity.domain.user.entity;

import com.MiniCommunity.domain.like.entity.Likes;
import com.MiniCommunity.domain.user.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String email;

    @Enumerated
    private Role role;

    @Column(nullable = false)
    private boolean isActive = true;

    @CreationTimestamp
    private LocalDateTime cDt;

    @UpdateTimestamp
    private LocalDateTime uDt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Likes> likes;

}
