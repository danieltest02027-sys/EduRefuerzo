package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.Tema;
import java.util.List;

public interface TemaService {
    public List<Tema> getTemas();
    public void save(Tema tema);
    public void delete(Tema tema);
    public Tema getTema(Tema tema);
}