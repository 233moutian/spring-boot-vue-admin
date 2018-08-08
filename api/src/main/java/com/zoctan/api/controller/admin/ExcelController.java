package com.zoctan.api.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zoctan.api.core.response.Result;
import com.zoctan.api.core.response.ResultGenerator;
import com.zoctan.api.model.Article;
import com.zoctan.api.util.DateUtilsZXW;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by zxw on 2018/7/26 0026.
 */
@RestController
@RequestMapping("/article")
public class ExcelController {


    @PreAuthorize("hasAuthority('article:list')")
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") final Integer page,
                       @RequestParam(defaultValue = "0") final Integer size) {
        PageHelper.startPage(page, size);
        final ArrayList<Article> list = new ArrayList<>();
        Article article1 = new Article(1, DateUtilsZXW.getCurrentTime(), "0.1", "reviewer0",  "Ijw6zgpKRh3OdCpHvBFKsfEnTGOxRKRBocCa3wfirgZJLJNhUVQhhIYqLTvPnCwV",  "content_short0",  "content0",  0.0f, DateUtilsZXW.getCurrentTime(), false, 0,  "image_uri");
        Article article2 = new Article(2, DateUtilsZXW.getCurrentTime(), "12", "reviewer0",  "aHR0cHM6Ly9lLmFiY2hpbmEuY29tL3FyY29kZS8jIS9xcmNvZGUvMDMdyasd2423",  "content_short0",  "content0",  0.0f, DateUtilsZXW.getCurrentTime(), false, 0,  "image_uri");
        Article article3 = new Article(3, DateUtilsZXW.getCurrentTime(), "30", "reviewer0",  "0RjNE9ESXhPREE0TURNd01UY3dNRE13TVRnPS9PRE16T0RjNE9ESXhNRE00T0RR2",  "content_short0",  "content0",  0.0f, DateUtilsZXW.getCurrentTime(), false, 0,  "image_uri");
        Article article4 = new Article(4, DateUtilsZXW.getCurrentTime(), "1.5", "reviewer0",  "E1ESTRPVUV4VTFBPS9PRE16T0RjNE9ESXhOVE16TWpnd01qZ3dNRGN4TURJMU5q3",  "content_short0",  "content0",  0.0f, DateUtilsZXW.getCurrentTime(), false, 0,  "image_uri");
        Article article5 = new Article(5, DateUtilsZXW.getCurrentTime(), "30", "reviewer0",  "T0RjNE9ESXhOVE16TWpnd01qZ3dNRGN4TURJMU5qRjNE9ESXhOVE16TWpnd01qZ3",  "content_short0",  "content0",  0.0f, DateUtilsZXW.getCurrentTime(), false, 0,  "image_uri");
        Article article6 = new Article(6, DateUtilsZXW.getCurrentTime(), "7.5", "reviewer0",  "syjf8iLbtxOZmA0qny+Lo5XML1W3znUB2t+gVDmizk6lg8qWhgSN3AAUumuw4qe7",  "content_short0",  "content0",  0.0f, DateUtilsZXW.getCurrentTime(), false, 0,  "image_uri");
        Article article7 = new Article(7, DateUtilsZXW.getCurrentTime(), "15", "reviewer0",  "IS9xcmNvZGUvMDMdyasd2423ESXxRKRBocCa3wfirgZJLJNhUVQhhIYqLTvPnCwV",  "content_short0",  "content0",  0.0f, DateUtilsZXW.getCurrentTime(), false, 0,  "image_uri");
        Article article8 = new Article(8, DateUtilsZXW.getCurrentTime(), "60", "reviewer0",  "jNE9ESXhOVE16TWpnd01qZ3E1PRE16T0RdNRGN4TURJMU5q3ESTRPVUV4VTFBPS9",  "content_short0",  "content0",  0.0f, DateUtilsZXW.getCurrentTime(), false, 0,  "image_uri");
        Article article9 = new Article(9, DateUtilsZXW.getCurrentTime(), "99", "reviewer0",  "S9PRE16T0RjNE9ESXhOV01qZ3dNRGN4TURJMU5q3E16E1ESTRPVUV4VTFBPTWpnd",  "content_short0",  "content0",  0.0f, DateUtilsZXW.getCurrentTime(), false, 0,  "image_uri");

        list.add(article1);
        list.add(article2);
        list.add(article3);
        list.add(article4);
        list.add(article5);
        list.add(article6);
        list.add(article7);
        list.add(article8);
        list.add(article9);
        //noinspection unchecked
        final PageInfo pageInfo = new PageInfo(list);

        return ResultGenerator.genOkResult(pageInfo);
    }
}
