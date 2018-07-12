package com.jonli.regioncode.presenter;

import com.jonli.regioncode.model.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jonli on 29.11.2017.
 */

public class CodePresenter implements Presenter {

    private Model model;

    public CodePresenter(Model model) {
        this.model = model;
    }

    @Override
    public String showRegion(String code) {
        if (model.getData().containsKey(code)) {
            return model.getData().get(code);
        } else {
            return "Данный код не существует";
        }
    }

    @Override
    public String showCode(String region) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : model.getData().entrySet()) {
            if (entry.getValue().equals(region)) {
                builder.append(entry.getKey()).append(", ");
            }
        }
        String result = builder.toString();
        return result.substring(0, result.length() - 2);
    }

    @Override
    public List<String> getRegions() {
        Set<String> set = new HashSet<>(model.getData().values());
        return new ArrayList<>(set);
    }

    @Override
    public String formatCode(String code) {
        if (code.length() == 1) {
            return String.format("0%s", code);
        }
        return code;
    }
}
