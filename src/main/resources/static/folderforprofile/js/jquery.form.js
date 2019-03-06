/*!

 * jQuery Form Plugin

 * version: 3.32.0-2013.04.09

 * @requires jQuery v1.5 or later

 * Copyright (c) 2013 M. Alsup

 * Examples and documentation at: http://malsup.com/jquery/form/

 * Project repository: https://github.com/malsup/form

 * Dual licensed under the MIT and GPL licenses.

 * https://github.com/malsup/form#copyright-and-license

 */

/*global ActiveXObject */

;(function($) {

"use strict";

/*

    Usage Note:

    -----------

    Do not use both ajaxSubmit and ajaxForm on the same form.  These

    functions are mutually exclusive.  Use ajaxSubmit if you want

    to bind your own submit handler to the form.  For example,

    $(document).ready(function() {

        $('#myForm').on('submit', function(e) {

            e.preventDefault(); // <-- important

            $(this).ajaxSubmit({

                target: '#output'

            });

        });

    });

    Use ajaxForm when you want the plugin to manage all the event binding

    for you.  For example,

    $(document).ready(function() {

        $('#myForm').ajaxForm({

            target: '#output'

        });

    });

    You can also use ajaxForm with delegation (requires jQuery v1.7+), so the

    form does not have to exist when you invoke ajaxForm:

    $('#myForm').ajaxForm({

        delegation: true,

        target: '#output'

    });

    When using ajaxForm, the ajaxSubmit function will be invoked for you

    at the appropriate time.

*/
