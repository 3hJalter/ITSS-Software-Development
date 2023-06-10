package ecoBikeSystem.repository;

import ecoBikeSystem.entity.TempEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TempRepository extends JpaRepository<TempEntity, UUID> {
    TempEntity getTempEntitiesById(UUID id);
}
