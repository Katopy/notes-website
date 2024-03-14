package com.ensolvers.notes.service;

import com.ensolvers.notes.model.CategoriesEntity;
import com.ensolvers.notes.repository.CategoryRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class CategoryService {
    @Inject
    CategoryRepository repo;

    public List<CategoriesEntity> list() {return repo.listAll();}



}
