Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext', '/webjars/extjs/4.2.0/');
Ext.require([
    'Ext.Msg',
    'Ext.data.*',
    'Ext.grid.*'
]);

Ext.define('Platform', {
    extend: 'Ext.data.Model',
    fields: [{
        name: 'id',
        type: 'int',
        useNull: true
    }, 'name', 'multicastAddress', 'comment']
});

Ext.onReady(function() {

    var store = Ext.create('Ext.data.Store', {
        autoLoad: true,
        autoSync: true,
        model: 'Platform',
        proxy: {
            type: 'rest',
            //url: 'Platforms',
            format: 'json',
            headers: {
                'Content-Type': 'application/json'
            },
            reader: {
                type: 'json',
                root: 'data'
            },
            writer: {
                type: 'json'
            },
            api: {
                create: '/platforms/create',
                read: '/platforms/list',
                update: '/platforms/edit',
                destroy: '/platforms/delete'
            }
        }
    });

    var rowEditing = Ext.create('Ext.grid.plugin.RowEditing');

    var grid = Ext.create('Ext.grid.Panel', {
        renderTo: document.body,
        height: 800,
        plugins: [rowEditing],

        frame: true,
        title: 'Platforms',
        store: store,
        columns: [{
            text: 'ID',
            width: 40,
            sortable: true,
            dataIndex: 'id'
        }, {
            text: 'Name',
            flex: 1,
            sortable: true,
            dataIndex: 'name',
            field: {
                xtype: 'textfield'
            }
        }, {
            header: 'Address',
            flex: 1,
            sortable: true,
            dataIndex: 'multicastAddress',
            field: {
                xtype: 'textfield'
            }
        }, {
            header: 'Comment',
            flex: 1,
            sortable: true,
            dataIndex: 'comment',
            field: {
                xtype: 'textfield'
            }
        }],
        dockedItems: [{
            xtype: 'toolbar',
            items: [{
                text: 'Add',
                iconCls: 'icon-add',
                handler: function() {
                    // empty record
                    store.insert(store.data.length, new Platform());
                    rowEditing.startEdit(store.data.length - 1, 0);
                }
            }, '-', {
                text: 'Delete',
                iconCls: 'icon-delete',
                handler: function() {
                    var selection = grid.getView().getSelectionModel().getSelection()[0];
                    if (selection) {
                        store.remove(selection);
                    }
                }
            }]
        }]
    });
});