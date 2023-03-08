import request from '@/utils/request'

//  分页查询列表
export function queryForPage(params) {
    console.log('分页查询列表', params)
    return request({
        url: 'classes/queryForPage',
        method: 'get',
        params
    })
}

//  保存表单
export function saveClasses(data) {
    console.log('保存表单', data)
    return request({
        url: 'classes/saveClasses',
        method: 'post',
        data
    })
}

// 修改表单
export function updateClasses(data) {
    console.log('修改表单', data)
    return request({
        url: 'classes/updateClasses',
        method: 'put',
        data
    })
}

// 通过指定id删除
export function deleteClasses(params) {
    console.log('通过指定id删除', params)
    return request({
        url: 'classes/deleteClasses',
        method: 'delete',
        params
    })
}