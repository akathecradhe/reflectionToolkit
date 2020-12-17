package com.nsa.group6.repositories;

import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.Tags;
import com.nsa.group6.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FormRepository extends JpaRepository<Form,Integer>{

    List<Form> findAllByUsername(User username, Sort lastEdited);
    Form findByFormID(int aFormId);
//    Integer countByTagsEquals(Tags tag);
    Integer countAllByTagsIsLikeAndUsernameLike(Tags tag,User user);
    Integer countAllByTagsIsLike(Tags tag);

    @Procedure("delete_activity")
    void deleteById(int id);

}
