package cn.edu.bit.ruixin.community.repository;

import cn.edu.bit.ruixin.community.domain.Permission;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * TODO
 *
 * This repo give the relationship between URL and permission.
 *
 * @author 78165
 * @author jingkaimori
 * @date 2021/7/8
 */
public interface PermissionRepository extends 
    JpaRepository<Permission, Integer>, JpaSpecificationExecutor<Permission> {
        
    @Query(nativeQuery=true,value="SELECT * FROM permission WHERE ? LIKE url")
    Permission findPermissionLikeUrl(String url);

    List<Permission> findByIdIn(List<Integer> permid);
    
}
