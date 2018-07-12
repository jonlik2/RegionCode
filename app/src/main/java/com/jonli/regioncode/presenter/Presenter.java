package com.jonli.regioncode.presenter;

import java.util.List;

/**
 * Created by Jonli on 29.11.2017.
 */

public interface Presenter {
    String showRegion(String code);

    String showCode(String region);

    List<String> getRegions();

    String formatCode(String code);
}
