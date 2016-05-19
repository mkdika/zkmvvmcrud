package com.mkdika.zkmvvmcrud.web.converter;

import java.util.List;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zul.Combobox;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public class StringListConverter implements Converter<String, Integer, Combobox> {

    @Override
    public String coerceToUi(Integer b, Combobox c, BindContext bc) {
        if (b != null) {
            List<String> list = (List<String>) c.getModel();
            return list.get(b);
        } else {
            return "";
        }
    }

    @Override
    public Integer coerceToBean(String u, Combobox c, BindContext bc) {
        if (u != null && !u.isEmpty()) {
            List<String> list = (List<String>) c.getModel();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(u)) {
                    return i;
                }
            }
            return null;
        } else {
            return null;
        }
    }
}
