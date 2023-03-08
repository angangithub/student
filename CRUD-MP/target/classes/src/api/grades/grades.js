import request from '@/utils/request'

//  分页查询列表
export function queryForPage(params) {
    console.log('分页查询列表', params)
    return request({
        url: 'grades/queryForPage',
        method: 'get',
        params
    })
}

//  保存表单
export function saveGrades(data) {
    console.log('保存表单', data)
    return request({
        url: 'grades/saveGrades',
        method: 'post',
        data
    })
}

// 修改表单
export function updateGrades(data) {
    console.log('修改表单', data)
    return request({
        url: 'grades/updateGrades',
        method: 'put',
        data
    })
}

// 通过指定id删除
export function deleteGrades(params) {
    console.log('通过指定id删除', params)
    return request({
        url: 'grades/deleteGrades',
        method: 'delete',
        params
    })
}