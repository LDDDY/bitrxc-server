package cn.edu.bit.ruixin.community.repository;

import cn.edu.bit.ruixin.community.domain.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * TODO
 *
 * @author 78165
 * @date 2021/3/25
 */
public interface GalleryRepository extends JpaRepository<Gallery, Integer>, JpaSpecificationExecutor<Gallery> {
}
