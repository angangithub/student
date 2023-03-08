import request from '@/utils/request'

//  分页查询列表
export function queryForPage(params) {
    console.log('分页查询列表', params)
    return request({
        url: 'courses/queryForPage',
        method: 'get',
        params
    })
}

//  保存表单
export function saveCourses(data) {
    console.log('保存表单', data)
    return request({
        url: 'courses/saveCourses',
        method: 'post',
        data
    })
}

// 修改表单
export function updateCourses(data) {
    console.log('修改表单', data)
    return request({
        url: 'courses/updateCourses',
        method: 'put',
        data
    })
}

// 通过指定id删除
export function deleteCourses(params) {
    console.log('通过指定id删除', params)
    return request({
        url: 'courses/deleteCourses',
        method: 'delete',
        params
    })
}