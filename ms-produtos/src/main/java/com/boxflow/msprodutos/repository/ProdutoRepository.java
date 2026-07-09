package com.boxflow.msprodutos.repository;

import com.boxflow.msprodutos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
