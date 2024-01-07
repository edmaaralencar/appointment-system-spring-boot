package br.com.edmaralencar.appointment.modules.categories.repositories;

import br.com.edmaralencar.appointment.modules.categories.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CategoriesRepository extends JpaRepository<Category, UUID> {
    @Query("SELECT c FROM categories c WHERE c.companies IS NOT EMPTY")
    List<Category> findAllActiveCategories();
}
