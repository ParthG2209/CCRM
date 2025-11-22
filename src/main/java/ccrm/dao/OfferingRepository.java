package ccrm.dao;

import ccrm.model.Offering;
import java.util.*;

public class OfferingRepository {
    private final Map<String, Offering> offerings = new HashMap<>();

    public void save(Offering o) {
        offerings.put(o.getId(), o);
    }

    public Offering findById(String id) {
        return offerings.get(id);
    }

    public Collection<Offering> findAll() {
        return offerings.values();
    }
}
