package com.zoctan.api.controller.admin;

import com.zoctan.api.core.response.Result;
import com.zoctan.api.core.response.ResultGenerator;
import com.zoctan.api.model.Bike;
import com.zoctan.api.service.BikeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 233moutian
 * @date 2018/08/29
 */
@RestController
@RequestMapping("/bike")
public class BikeController {
    @Resource
    private BikeService bikeService;

    @PostMapping
    public Result add(@RequestBody Bike bike) {
bikeService.save(bike);
        return ResultGenerator.genOkResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
bikeService.deleteById(id);
        return ResultGenerator.genOkResult();
    }

    @PutMapping
    public Result update(@RequestBody Bike bike) {
bikeService.update(bike);
        return ResultGenerator.genOkResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
Bike bike = bikeService.findById(id);
        return ResultGenerator.genOkResult(bike);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Bike> list = bikeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genOkResult(pageInfo);
    }
}
