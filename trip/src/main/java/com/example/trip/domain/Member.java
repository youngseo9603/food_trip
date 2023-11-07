package com.example.trip.domain;

import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "members")
@Getter @Setter @Data
@ConstructorBinding
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "memberIndex")
    private Long memberIndex;

    @OneToMany(mappedBy = "member")
    private List<Board> boards;

    private String loginId;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    private String name;

}
