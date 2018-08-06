import request from '@/utils/request'

export function listPermission(params) {
  return request({
    url: '/permission/listPermission',
    method: 'get',
    params
  })
}

export function fetchPermission(id) {
  return request({
    url: '/permission/detail',
    method: 'get',
    params: { id }
  })
}

export function remove(id) {
  return request({
    url: '/permission/' + id,
    method: 'delete'
  })
}

export function createPermission(data) {
  return request({
    url: '/permission',
    method: 'post',
    data
  })
}

export function updatePermission(data) {
  return request({
    url: '/permission',
    method: 'put',
    data
  })
}
