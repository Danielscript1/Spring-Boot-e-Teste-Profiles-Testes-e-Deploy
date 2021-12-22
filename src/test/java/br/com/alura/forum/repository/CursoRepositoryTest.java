package br.com.alura.forum.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.modelo.Curso;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.AUTO_CONFIGURED.NONE)
@ActiveProfiles("test")
public class CursoRepositoryTest {
	
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloNome() {
		String nomeCurso = "HTML 5";
		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		html5.setCategoria("programacao");
		em.persist(html5);
		Curso curso = cursoRepository.findByNome(nomeCurso);
		Assert.assertNotNull(curso);
		Assert.assertEquals(nomeCurso,curso.getNome());
	}

}
