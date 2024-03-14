package com.ensolvers.notes.repository;

import com.ensolvers.notes.model.CategoriesEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepository  implements PanacheRepository<CategoriesEntity> {

}
