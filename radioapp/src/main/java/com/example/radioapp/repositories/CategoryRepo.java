package com.example.radioapp.repositories;

        import com.example.radioapp.entities.Category;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {


}
