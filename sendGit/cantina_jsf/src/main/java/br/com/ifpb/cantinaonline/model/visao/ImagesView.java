package br.com.ifpb.cantinaonline.model.visao;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
@ManagedBean
public class ImagesView {
    private List<String> images;

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 2; i <= 5; i++) {
            images.add("lanche" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }
}

