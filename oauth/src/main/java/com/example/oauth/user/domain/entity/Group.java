package com.example.oauth.user.domain.entity;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "groups")
public class Group {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "group")
  private List<GroupPermission> permissions = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<GrantedAuthority> getAuthorities() {
    return permissions.stream()
      .map(gp -> new SimpleGrantedAuthority(gp.getPermission().getName()))
      .collect(toList());
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
      .append("id", id)
      .append("name", name)
      .append("authorities", getAuthorities())
      .toString();
  }

}