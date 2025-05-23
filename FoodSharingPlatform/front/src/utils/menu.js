const menu = {
  list() {
    return [
      {
        backMenu: [
          {
            child: [
              {
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "用户",
                menuJump: "列表",
                tableName: "yonghu",
              },
            ],
            menu: "用户管理",
          },
        //   {
        //     child: [
        //       {
        //         buttons: ["新增", "查看", "修改", "删除", "查看评论"],
        //         menu: "美食鉴赏",
        //         menuJump: "列表",
        //         tableName: "meishijianshang",
        //       },
        //     ],
        //     menu: "美食鉴赏管理",
        //   },
          {
            child: [
              {
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "我的好友",
                menuJump: "列表",
                tableName: "wodehaoyou",
              },
            ],
            menu: "我的好友管理",
          },
          {
            child: [
              {
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "我的收藏管理",
                tableName: "storeup",
              },
            ],
            menu: "我的收藏管理",
          },
          {
            child: [
              {
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "轮播图管理",
                tableName: "config",
              },
            ],
            menu: "系统管理",
          },
        ],
        frontMenu: [
        //   {
        //     child: [
        //       {
        //         buttons: ["查看", "添加好友"],
        //         menu: "美食鉴赏列表",
        //         menuJump: "列表",
        //         tableName: "meishijianshang",
        //       },
        //     ],
        //     menu: "美食鉴赏模块",
        //   },
          {
            child: [
              {
                buttons: ["查看"],
                menu: "我的好友列表",
                menuJump: "列表",
                tableName: "wodehaoyou",
              },
            ],
            menu: "我的好友模块",
          },
        ],
        hasBackLogin: "是",
        hasBackRegister: "否",
        hasFrontLogin: "否",
        hasFrontRegister: "否",
        roleName: "管理员",
        tableName: "users",
      },
      {
        backMenu: [
        //   {
        //     child: [
        //       {
        //         buttons: ["查看", "查看评论", "修改", "新增"],
        //         menu: "美食鉴赏",
        //         menuJump: "列表",
        //         tableName: "meishijianshang",
        //       },
        //     ],
        //     menu: "美食鉴赏管理",
        //   },
          {
            child: [
              {
                buttons: ["修改"],
                menu: "我的好友",
                menuJump: "列表",
                tableName: "wodehaoyou",
              },
            ],
            menu: "我的好友管理",
          },
          {
            child: [
              {
                buttons: ["查看", "删除", "新增", "修改"],
                menu: "我的收藏管理",
                tableName: "storeup",
              },
            ],
            menu: "我的收藏管理",
          },
        ],
        frontMenu: [
        //   {
        //     child: [
        //       {
        //         buttons: ["查看", "添加好友"],
        //         menu: "美食鉴赏列表",
        //         menuJump: "列表",
        //         tableName: "meishijianshang",
        //       },
        //     ],
        //     menu: "美食鉴赏模块",
        //   },
          {
            child: [
              {
                buttons: ["查看"],
                menu: "我的好友列表",
                menuJump: "列表",
                tableName: "wodehaoyou",
              },
            ],
            menu: "我的好友模块",
          },
        ],
        hasBackLogin: "是",
        hasBackRegister: "是",
        hasFrontLogin: "是",
        hasFrontRegister: "是",
        roleName: "用户",
        tableName: "yonghu",
      },
    ];
  },
};
export default menu;
