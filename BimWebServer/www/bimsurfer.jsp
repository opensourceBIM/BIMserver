<!doctype html>
<html lang='en'>
<!--
      BIMsurfer - An open source WebGL viewer for IFC models.
      Copyright 2011, BIMserver.org.
-->
<head>
  <meta charset='utf-8'>
  <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'>
  <title>BIMsurfer</title>
  <meta name='description' content='A sleek WebGL viewer for Building Information Models'>
  <meta name='author' content='Rehno Lindeque'>
  <link rel="shortcut icon" href="/favicon.ico">

  <!-- Stylesheet -->

  <link type='text/css' href='static/lib/jquery/jquery-ui-1.8.15.custom.css' rel='stylesheet' />	
  <style type='text/css' media='screen'>
    /* Resets */
    * {
      margin: 0;
      padding: 0;
    }
    a {
      text-decoration: none;
      outline: none;
    }
    menu {
      list-style: none;
      list-style-image: none;
    }
    
    /* Normalization (taken from http://necolas.github.com/normalize.css/ and a little bit from html5 boilerplate) */
    html {
      -webkit-text-size-adjust: 100%;
      -ms-text-size-adjust: 100%;
    }
    abbr[title] {
      border-bottom: 1px dotted;
    }
    b, 
    strong { 
      font-weight: bold; 
    }
    blockquote {
      margin: 1em 40px;
    }
    dfn {
      font-style: italic;
    }
    pre {
      white-space: pre;
      white-space: pre-wrap;
      word-wrap: break-word;
    }
    pre, 
    code, 
    kbd,
    samp { 
      font-family: monospace, monospace;
      font-size: 1em;
    }
    small {
      font-size: 75%;
    }
    sub,
    sup {
      font-size: 75%;
      line-height: 0;
      position: relative;
      vertical-align: baseline;
    }
    sup {
      top: -0.5em;
    }
    sub {
      bottom: -0.25em;
    }
    button,
    input,
    select,
    textarea {
      vertical-align: baseline;
    }
    button,
    html input[type="button"],
    input[type="reset"],
    input[type="submit"] {
      cursor: pointer;
      -webkit-appearance: button;
    }
    input[type="search"] {
      -webkit-appearance: textfield;
      -moz-box-sizing: content-box;
      -webkit-box-sizing: content-box;
      box-sizing: content-box;
    }
    input[type="search"]::-webkit-search-decoration {
      -webkit-appearance: none;
    }
    button::-moz-focus-inner, 
    input::-moz-focus-inner { 
      border: 0;
    }
    textarea {
      vertical-align: top;
    }
    table {
      border-collapse: collapse;
      border-spacing: 0;
    }
    img {
      border: 0;
      vertical-align: middle; 
    }
    label { 
      cursor: pointer; 
    }

    /* General styling */
    * {
      color: #444;
    }
    html {
      height: 100%;
      overflow: hidden;
    }
    body { 
      background: rgb(255,255,255); 
      height: 100%;
      font-family: arial, sans-serif;
    }
    a {
      color: #3a74ae;
    }
    h2 {
      font-size: 20px;
    }
    h3 {
      font-size: 17px;
      margin: 0 0 4px 15px;
    }
    textarea {
      resize: vertical;
    }
    menu li menu {
      display: none;
    }
    menu li:hover menu {
      display: block;
    }
    menu hr {
      border: none;
      height: 1px;
      background-color: #666;
      color: #666;
      width: 60%;
      margin: 8px auto;
    }
    input[type='url'], input[type='email'], input[type='password'] {
      background: #eee;
      border: solid 1px #ccc;
      padding: 2px ;
    }
    button[disabled]{
      color: #ccc;
    }
    input.error {
      background: #fee;
      border: solid 1px #f44;
    }
    input[type='file'] {
      cursor: pointer;
      display: inline;
    }

    /* Generic classes */
    .clickable {
      cursor: pointer;
    }
    .horizontal-list li {
      display: inline-block;
    }
    .vertical-list li {
      display: block;
    }
    .indent-1 {
      display: inline-block;
      padding: 0 0 0 10px;
    }
    .indent-2 {
      display: inline-block;
      padding: 0 0 0 20px;
    }
    .indent-3 {
      display: inline-block;
      padding: 0 0 0 30px;
    }
    .indent-4 {
      display: inline-block;
      padding: 0 0 0 40px;
    }
    .indent-5 {
      display: inline-block;
      padding: 0 0 0 50px;
    }
    .indent-6 {
      display: inline-block;
      padding: 0 0 0 55px;
    }
    .unobtrusive-scroll::-webkit-scrollbar {
      width: 2px;
    }
    .unobtrusive-scroll::-webkit-scrollbar-thumb:vertical {
      height: 50px;
      background-color: #bbb;
    }
    .position-left {
      position: absolute;
      left: 0;
    }
    .position-top-right {
      position: absolute;
      top: 0;
      right: 0;
    }
    .firefox-relative-cell { 
      /* This class is added to a div in a table cell in order to get relative positioning in firefox. It is not needed in chrome. */
      position: relative;
      width: 100%;
      height: 100%
    }
    
    /* Application styling */
    #dialog-background {
      position: absolute;
      z-index: 999;
      width: 100%;
      height: 100%;
      background: rgba(220,220,220, 0.3);
    }
    .dialog-frame {
      position: absolute;
      top: 50%;
      left: 50%;
      margin: -150px 0 0 -250px;
      width: 500px;
      height: 300px;
      background: #fff;
      border: solid 1px #aaa;
      -moz-box-shadow: 0 0 5px rgba(100,100,100,0.5), 0 0 100px #aaa;
      -webkit-box-shadow: 0 0 5px rgba(100,100,100,0.5), 0 0 100px #aaa;
      box-shadow: 0 0 5px rgba(100,100,100,0.5), 0 0 100px #aaa;
    }
    .dialog-close {
      position: absolute;
      top: 0;
      right: 4px;
    }
    .dialog-steps {
      padding: 10px 0 0 4px;
      width: 150px;
      float: left;
    }
    .dialog-step {
      display: block;
      background: #ccc;
      background: -webkit-gradient(linear, 0% 0%, 100% 0%, from(#ccc), to(#fff));
      background: -webkit-linear-gradient(left, #ccc, #fff);
      background: -moz-linear-gradient(left, #ccc, #fff);
      color: #444;
      padding: 8px 6px;
    }
    .dialog-step-active {
      background: #3a74ae; /*gradient? 2d5b89 */
      background: -webkit-gradient(linear, 0% 0%, 100% 0%, from(#3a74ae), to(#fff));
      background: -webkit-linear-gradient(left, #3a74ae, #fff);
      background: -moz-linear-gradient(left, #3a74ae, #fff);
      color: #fff;
    }
    .dialog-main {
      padding: 10px 0 0 10px;
      display: inline-block;
    }
    .dialog-main label {
      display: inline-block;
      width: 80px;
      text-align: right;
      padding: 6px 8px;
    }
    .dialog-messages {
      margin: 8px 0;
      text-align: right;
      font-size: 13px;
    }
    .dialog-button {
      float: right;
      padding: 4px 8px;
    }
    .dialog-buttons {
      margin: 0 0 0 10px;
    }
    .dialog-message-info {
      color: #44f;      
    }
    .dialog-message-error {
      color: #f44;
    }
    #dialog-logo-bimserver {
      background: url('static/images/bimserver-logo.png');
      height: 70px;
      width: 256px;
      margin: 4px auto 10px auto;
      border-bottom: solid 1px #ccc;
    }
    #dialog-logo-file {
      text-align: center;
      font-size: 32px;
      height: 70px;
      line-height: 70px;
      width: 256px;
      margin: 4px auto 10px auto;
      border-bottom: solid 1px #ccc;
    }
    #bimserver-projects {
      border: solid 1px #ccc;
      height: 150px;
      width: 272px;
      padding: 3px;
      overflow-y: auto;
    }
    .bimserver-project {
      list-style: none;
      list-style-image: none;
      display: block;
      -moz-box-sizing: border-box;
      -ms-box-sizing: border-box;
      -webkit-box-sizing: border-box;
      box-sizing: border-box;
      cursor: pointer;
      padding: 4px 8px;
      font-size: 13px;
      width: 100%;
    }
    .bimserver-project:hover {
      background: #eff5fb;
    }
    .bimserver-project-selected, .bimserver-project-selected:hover {
      background: #c8e0f9;
    }
    #upload-file {
      margin: 7px 0 0 0;
    }
    #upload-file-info {
      height: 50px;
      width: 272px;
      margin: 10px 0 0 0;
      border: 1px solid #ccc;
    }
    #main-layout {
      /*display: -webkit-box;
      display: -moz-box;
      display: box;
      -webkit-box-orient: vertical;
      -moz-box-orient: vertical;
      box-orient: vertical;*/
      width: 100%;
      height: 100%;
      /* Alternate table layout */
      display: table;
    }
    .main-layout-row {
      /*display: -webkit-box;
      display: -moz-box;
      display: box;
      -webkit-box-flex: 1;
      -moz-box-flex: 1;
      box-flex: 1;*/
      /* Alternate table layout */
      display: table-row;
    }
    #top-menu {
      background: #2d2d2d;
      text-align: right;
      width: 100%;
      height:22px;
      border-bottom: 1px solid black;
      /* Alternate table layout */
      display: table-row;
    }
    #top-menu li {
      position: relative;
      text-align: left;
      padding: 3px 10px;
    }
    #top-menu h4 {
      color: #666;
      text-align: right;
      font-size: 11px;
      font-weight: normal;
    }
    #top-menu a {
      display: block;
      color: #ddd;
      line-height: 18px;
      margin: 0 5px;
      padding: 0 13px;
      font-size: 13px;
    }
    #top-menu a:hover {
      color: #fff;
    }
    .top-menu-left {
      float: left;
      margin: 0 0 0 1px; /* This 1px margin prevents chrome from assuming you're hovering at (0,0) over the menu when the page opens */
    }
    .top-menu-dropdown {
      position: absolute;
      padding: 5px 0 0 0;
      margin: 0 0 0 3px;
      width: 150px;
      left: 0;
      z-index: 100;
    }

    .top-menu-float {
      border: 1px black;
      background: #2d2d2d;
      -moz-border-radius: 5px;
      border-radius: 5px;
      padding: 8px 10px;
    }
    #top-menu .top-menu-float li {
      padding: 0 10px;
    }
    .top-menu-activated {
      background: #667;
      background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#556), to(#666673));
      background: -webkit-linear-gradient(top, #556, #666673);
      background: -moz-linear-gradient(top, #556, #666673);
      -webkit-background-clip: padding-box;
      border-radius: 7px;
      -moz-border-radius: 7px;
      -webkit-border-radius: 7px;
    }
    #top-menu .top-menu-dropdown a {
      margin: 0;
      padding: 0;
    }
    #main-menu {
      /*-webkit-box-flex: 1;
    	-moz-box-flex: 1;
    	box-flex: 1;*/
      position: absolute;
      width: 100%;
      z-index: 1;
      /*border-bottom: 1px solid #e2e2e2;*/
      height: 120px;
    }
    #main-menu div {
      display: inline-block;
      vertical-align: middle;
    }
    #main-menu-logo {
      background: url('static/images/main-menu-logo.png');
      height: 85px;
      /*height: 70px;*/
      width: 245px;
      margin: 10px 40px 0 10px;
    } 
    .main-menu-panel {
      padding:10px;
      margin: 7px 20px;
      width: 200px;
      background: #f1f1f1;
      border: solid 1px #cacaca;
      /*-moz-box-shadow: 0 0 5px rgba(20,20,20,0.2);
      -webkit-box-shadow: 0 0 5px rgba(20,20,20,0.2);
      box-shadow: 0 0 5px rgba(20,20,20,0.2);*/
    }
    .main-menu-panel h3 {
      color: #666;
      font-size: 20px;
      text-shadow: 1px 1px 0px #fff;
    }
    .main-menu-panel a {
      color: #ccc;
      font-size: 14px;
    }
    .main-menu-panel a:hover {
      color: #3a74ae;
    }
    #main-view {
      position: relative;
      /*display: -webkit-box;
      display: -moz-box;
      display: box;
      -webkit-box-orient: horizontal;
      -moz-box-orient: horizontal;
      box-orient: horizontal;
      -webkit-box-flex: 1;
      -moz-box-flex: 1;
      box-flex: 1;*/
      background: -moz-linear-gradient(left, rgba(0,0,0,0.1) 0%, rgba(0,0,0,0.0) 40%, rgba(0,0,0,0.0) 60%, rgba(0,0,0,0.1) 100%),
                  -moz-linear-gradient(top, rgba(0,0,0,0.08) 0%, rgba(0,0,0,0) 5%, rgba(0,0,0,0) 95%, rgba(0,0,0,0.08) 100%); /* FF3.6+ */
      background: -webkit-gradient(linear, left top, right top, color-stop(0%,rgba(0,0,0,0.1)), color-stop(40%,rgba(0,0,0,0.0)), color-stop(60%,rgba(0,0,0,0.0)), color-stop(100%,rgba(0,0,0,0.1))),
                  -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0.08)), color-stop(5%,rgba(0,0,0,0)), color-stop(95%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.08))); /* Chrome,Safari4+ */
      background: -webkit-linear-gradient(left, rgba(0,0,0,0.1) 0%, rgba(0,0,0,0.0) 30%, rgba(0,0,0,0.0) 70%, rgba(0,0,0,0.1) 100%),
                  -webkit-linear-gradient(top, rgba(0,0,0,0.08) 0%, rgba(0,0,0,0) 5%, rgba(0,0,0,0) 95%, rgba(0,0,0,0.08) 100%); /* Chrome10+,Safari5.1+ */
      /* Alternate table layout */
      display: table-cell;
    }
    #viewport {
      position: absolute;
      width: 100%;
      height: 100%;
    }
    .viewport-performance {
      top: 122px;
    }
    .bimsurfer-empty-watermark {
      background: center no-repeat url('static/images/bimsurfer-empty-watermark.png');
      background-size: 400px 434px;
    }
    #scenejsCanvas {
      display: block;
      margin: 0 auto;
    }
    #main-view-controls {
      position: absolute;
      top: 140px;
      width: 300px;
      font-size: 13px;
      margin-left: 10px;
    }
    #controls-accordion-objects {
      padding: 0;
      font-size: 12px;
      overflow-y: scroll;
    }
    #controls-accordion-properties {
      padding: 4px;
      font-size: 12px;
    }
    #controls-relationships {
      min-height: 200px;
    }
    .controls-tree {
      list-style: none;
      list-style-image: none;
      cursor: pointer;
      display: none;
    }
    .controls-tree-item {
      padding: 4px 2px 4px 10px;
    }
    .controls-tree-item:hover {
      background: #eff5fb;
    }
    .controls-tree-postfix {
      float: right;
      color: #aaa;
    }
    #controls-relationships > .controls-tree {
      display: block;
    }
    .controls-tree-open > .controls-tree {
      display: block;
    }
    .controls-tree-selected, .controls-tree-selected:hover {
      background: #c8e0f9;
    }
    .controls-tree-selected-parent {
      display: block;
    }
    .controls-tree-heading {
      display: none; /* Hide it for now - doesn't look good enough yet */
      width: 100%;
      text-align: right;
    }
    .controls-tree-heading h4 {
      display: inline-block;
      color: #88b;
      font-size: 10px;
      font-weight: normal;
      margin: -2px 2px;
    }
    .controls-tree-heading hr {
      border: none;
      height: 1px;
      background-color: #88b;
      color: #88b;
      display: inline-block;
      width: 20%;
      vertical-align: middle;
    }
    .controls-table {
      display: table;
      width: 100%;
      border-collapse: collapse;
    }
    .controls-table-item {
      display: table-row;
    }
    .controls-table-label, .controls-table-value {
      display: table-cell;
      border: 1px solid #999;
      padding: 4px;
    }
    .controls-table-label {
      background: #ddd;
      font-size: 11px;
      width: 65px;
    }
    .controls-table-value {
      background: #fff;
      color: #222;
    }
    .controls-message {
      font-size: 13px;
      font-style: italic;
      color: #666;
      margin: 15px;
    }
    #main-view-keys {
      position: absolute;
      bottom: 40px;
      right: 0;
      font-size: 13px;
    }
    .shortcut {
      position: relative;
      display: none;
      width: 220px;
      padding: 3px 0;
    }
    .shortcut div {
      display: inline-block;
      vertical-align: middle;
    }
    .shortcut-key {
      color: #555;
      font-size: 12px;
      padding: 3px 5px;
      border: solid 1px #aaa;
      background: #eee;
      border-radius: 6px;
      font-weight: bold;
    }
    .shortcut-description {
      position: absolute;
      right: 0;
      padding: 4px 0;
      width: 170px;
    }
    .shortcut-mouse-left,
    .shortcut-mouse-middle,
    .shortcut-mouse-right,
    .shortcut-mouse-scroll {
      width: 24px;
      height: 24px;
    }
    .shortcut-mouse-left {
      background: url('static/images/shortcut-mouse-left24x24.png');
    }
    .shortcut-mouse-middle {
      background: url('static/images/shortcut-mouse-middle24x24.png');
    }
    .shortcut-mouse-right {
      background: url('static/images/shortcut-mouse-right24x24.png');
    }
    .shortcut-mouse-scroll {
      background: url('static/images/shortcut-mouse-scroll24x24.png');
    }
    #main-view-help {
      position: absolute;
      display: block;
      bottom: 30px;
      color: #777;
      font-size: 13px;
      text-align: center;
      width: 100%;
    }
    #snapshots-fold {
      /*display: -webkit-box;
      display: -moz-box;
      display: box;
      -webkit-box-orient: vertical;
      -moz-box-orient: vertical;
      box-orient: vertical;*/
      padding: 6px 0 0 25px;
      width: 150px;
      vertical-align: top;
      background: rgb(245,245,245); /* Old browsers */
      background: -moz-linear-gradient(left, rgba(211,211,211,1) 0%, rgba(245,245,245,1) 20%, rgba(245,245,245,1) 100%); /* FF3.6+ */
      background: -webkit-gradient(linear, left top, right top, color-stop(0%,rgba(211,211,211,1)), color-stop(20%,rgba(245,245,245,1)), color-stop(100%,rgba(245,245,245,1))); /* Chrome,Safari4+ */
      background: -webkit-linear-gradient(left, rgba(211,211,211,1) 0%, rgba(245,245,245,1) 20%, rgba(245,245,245,1) 100%); /* Chrome10+,Safari5.1+ */
      border-left: 1px solid #ccc;
      /* Alternate table layout */
      position: relative;
      display: table-cell;
      height: 100%;
      max-height: 100%;
    }
    #snapshots-fold h2 {
      text-align: center;
      width: 125px;
    }
    #snapshots {
      width: 125px;
    }
    #snapshots-area {
      /*-webkit-box-flex: 1;
      -moz-box-flex: 1;
      box-flex: 1;*/
      overflow-y: auto;
      /* Alternate table layout */
      position: absolute;
      width: 150px;
      top: 20px;
      bottom: 30px;
      right: 0;
    }
    .snapshot-thumb {
      display: inline-block;
      vertical-align: middle;
      position: relative;
      margin-top: 10px;
      width: 125px;
      height: 100px;
      cursor: pointer;
    }
    .snapshot-delete {
      position: absolute;
      display: none;
      right: 4px;
    }
    .snapshot:hover .snapshot-delete {
      display: block;
    }
    #snapshot-placeholder  {
      display: block;
      border: 1px dashed #3a74ae;
      font-size: 13px;
      margin-right: 10px;
      margin-top: 10px;
      width: 125px;
      height: 100px;
      line-height: 100px;
      text-align: center;
    }
    #snapshot-placeholder div {
      /*margin: auto auto;
      display: inline-block;*/
    }
    #snapshots-toolbar {
      position: relative;
      padding: 1px 0 0 0;
      /* Alternate table layout */
      width: 150px;
      position: absolute;
      bottom: 0;
      right: 0;
    }
    #snapshots-toolbar li {
      font-size: 15px;
      line-height: 26px;
    }
    #snapshots-toolbar-export {
      background: #f1f1f1;
      padding: 0 10px;
      border: solid 1px #e2e2e2;
      min-width: 50px;
      text-align: center;
    }
    .snapshots-toolbar-pullup {
      position: absolute;
      bottom: 26px;
      right: 0;
      padding: 0 10px;
      min-width: 50px;
      line-height: auto;
      background: #f5f5f5;
      border: solid 1px #ccc;
    }
    .ifc-link, .controls-table-value .ifc-link {
      color: #3a74ae;
    }

    /* JQuery UI overides */
    .ui-accordion-content {
      background: #f1f1f1;
    }
  </style>
</head>
<body>

  <!-- Screen layout -->

  <div id='scenejsLog' style='display:none;'></div>
  <div id='dialog-background' style='display:none;'>
    <div id='dialog-file-import' class='dialog-frame' style='display:none;'>
      <a class='dialog-close' href='#'>x</a>
      <div id='dialog-logo-file'>SceneJS File</div>
      <div class='dialog-steps'>
        <a id='file-import-step1' class='dialog-step dialog-step-active' href='#'>Select file</a>
      </div>
      <div class='dialog-main'>
        <form id='upload-form' class='dialog-tab' onsubmit='return false;'>
          <input type='file' id='upload-file' name='upload-file'>
          <div id='upload-file-info'></div>
          <div class='dialog-buttons'><button type='submit' class='dialog-button'>Open</input></div>
          <div class='dialog-messages'>
            <p id='file-import-message-info' class='dialog-message-info'></p>
            <p id='file-import-message-error' class='dialog-message-error'></p>
          </div>
        </form>
      </div>
    </div>
    <div id='dialog-bimserver-import' class='dialog-frame' style='display:none;'>
      <a class='dialog-close' href='#'>x</a>
      <div id='dialog-logo-bimserver'></div>
      <div class='dialog-steps'>
        <a id='bimserver-import-step1' class='dialog-step dialog-step-active' href='#'>Login</a>
        <a id='bimserver-import-step2' class='dialog-step' href='#'>Choose a project</a>
      </div>
      <div class='dialog-main'>
        <form id='dialog-tab-bimserver1' class='dialog-tab' onsubmit='return false;' style='display:none;'>
          <div><label for='bimserver-login-url'>BIMserver</label><input id='bimserver-login-url' name='bimserver-login-url' type='url' value='http://localhost:8080'></div>
          <div><label for='bimserver-login-username'>Username</label><input id='bimserver-login-username' name='bimserver-login-username' type='email' placeholder='user@website.com'></div>
          <div><label for='bimserver-login-password'>Password</label><input id='bimserver-login-password' name='bimserver-login-password' type='password'></div>
          <div class='dialog-buttons'><button id='bimserver-login-submit' type='submit' class='dialog-button'>Login</button></div>
          <div class='dialog-messages'>
            <p id='bimserver-import-message-info' class='dialog-message-info'></p>
            <p id='bimserver-import-message-error' class='dialog-message-error'></p>
          </div>
        </form>
        <form id='dialog-tab-bimserver2' class='dialog-tab' onsubmit='return false;' style='display:none;'>
          <ul id='bimserver-projects'></ul>
          <div class='dialog-buttons'>
            <button id='bimserver-projects-submit' class='dialog-button' disabled='disabled'>Open</button>
            <button id='bimserver-projects-refresh' class='dialog-button'>Refresh</button>
          </div>
        </form>
      </div>
    </div>
  </div>

  <div id='main-layout'>
    <menu id='top-menu' class='horizontal-list' type='toolbar'>
      <li class='top-menu-left'>
        <a id='top-menu-return-bimserver' href='http://localhost:8082/' style='display: none'>&lt; BiMserver</a>
        <a href='#'>File</a>
        <menu class='top-menu-dropdown vertical-list'><div class='top-menu-float'>
          <h4>Import</h4>
          <li><a href='#' id='top-menu-import-bimserver'>BIMserver Project</a></li>
          <li><a href='#' id='top-menu-import-scenejs'>SceneJS File</a></li>
        </div></menu>
      </li>
      <li>
        <a href='#'>Display</a>
        <menu class='top-menu-dropdown vertical-list'><div class='top-menu-float'>
          <h4>Palette</h4>
          <li><a href='#' id='top-menu-palette-winter'>Winter Colors</a></li>
          <li><a href='#' id='top-menu-palette-autumn'>Autumn Colors</a></li>
          <li><a href='#' id='top-menu-palette-spring'>Spring Colors</a></li>
          <li><a href='#' id='top-menu-palette-summer'>Summer Colors</a></li>
        </div></menu>
      </li>
      <li>
        <a href='#'>Settings</a>
        <menu class='top-menu-dropdown vertical-list'><div class='top-menu-float'>
          <h4>Performance</h4>
          <li><a href='#' id='top-menu-performance-quality' class='top-menu-activated'>High Quality</a></li>
          <li><a href='#' id='top-menu-performance-performance'>High Performance</a></li>
          <hr>
          <h4>Mode</h4>
          <li><a href='#' id='top-menu-mode-basic' class='top-menu-activated'>Basic Mode</a></li>
          <li><a href='#' id='top-menu-mode-advanced'>Advanced Mode</a></li>
        </div></menu>
      </li>
      <li>
        <a href='#'>Share</a>
        <menu class='top-menu-dropdown vertical-list'><div class='top-menu-float'>
          <li><a href='#' id='top-menu-share-facebook'>Facebook</a></li>
          <li><a href='#' id='top-menu-share-twitter'>Twitter</a></li>
          <li><a href='#' id='top-menu-share-gplus'>Google+</a></li>
          <li><a href='#' id='top-menu-share-email'>Email</a></li>
        </div></menu>
      </li>
      <li><a href='#' id='top-menu-about'>About</a></li>
      <li><a href='#' id='top-menu-help' class='top-menu-activated'>Help</a></li>
    </menu>
    <div class='main-layout-row'><div style='display:table;width:100%;height:100%'><div style='display:table-row;width:100%;height:100%'>
      <div id='main-view'><div class='firefox-relative-cell'>
        <div id='main-menu'>
          <div id='main-menu-logo'></div>
          <!-- --
          <div class='main-menu-panel ui-widget-content'>
            <h3>Controls</h3>
            <menu type='toolbar'>
              <li><a href='#'>+ Select</a></li>
              <li><a href='#'>+ Arcball</a></li>
              <li><a href='#'>+ Annotate</a></li>
            </menu>
          </div>
          <!-- -->
          <div class='main-menu-panel ui-widget-content'>
            <h3>Views</h3>
            <menu type='toolbar'>
              <li><a href='#' id='main-views-reset'>+ Reset</a></li>
              <!-- --
              <li><a href='#'>+ 4 Views</a></li>
              <li><a href='#'>+ Orthogonal</a></li>
              <li><a href='#'>+ First person</a></li>
              <!-- -->
            </menu>
          </div>
        </div>
        <div id='viewport'>
          <!-- -->
          <canvas id='scenejsCanvas' width='1024' height='512'>
            <p>This application requires a browser that supports the<a href='http://www.w3.org/html/wg/html5/'>HTML5</a>&lt;canvas&gt; feature.</p>
          </canvas>
          <!-- -->
        </div>
        <div id='main-view-keys'>
          <div class='shortcut shortcut-selection shortcut-inspection'><div class='shortcut-mouse-left'></div>x2<span class='shortcut-description'>Inspect element</span></div>
          <div class='shortcut shortcut-navigation'><div class='shortcut-mouse-left'></div><span class='shortcut-description'>Select an element</span></div>
          <div class='shortcut shortcut-navigation'><div class='shortcut-mouse-left'></div><span class='shortcut-description'>Rotate the view</span></div>
          <div class='shortcut shortcut-navigation'><div class='shortcut-mouse-middle'></div><span class='shortcut-description'>Pan the view</span></div>
          <div class='shortcut shortcut-navigation'><div class='shortcut-mouse-scroll'></div><span class='shortcut-description'>Zoom in and out</span></div>
          <div class='shortcut shortcut-standard'><div class='shortcut-key'>F11</div><span class='shortcut-description'>Fullscreen mode</span></div>
          <div class='shortcut shortcut-standard'><div class='shortcut-key'>h</div><span class='shortcut-description'>Toggle help</span></div>
        </div>
        <div id='main-view-controls' style='visibility: hidden;'>
          <div id='controls-accordion'>
            <h3><a href='#'>Objects</a></h3>
            <div id='controls-accordion-objects' class='unobtrusive-scroll'>
              <form id='controls-relationships'></form>
            </div>
            <h3><a href='#'>Properties</a></h3>
            <div id='controls-accordion-properties'>
              <form id='controls-properties'></form>
            </div>
            <h3><a href='#'>Layers</a></h3>
            <div><form id='controls-layers'></form></div>
            <!-- --
            <h3><a href='#'>Annotations</a></h3>
            <div></div>
            <!-- -->
          </div>
        </div>
        <div id='main-view-help'></div>
      </div></div>
      <div id='snapshots-fold'><div class='firefox-relative-cell'>
        <div><h2>Snapshots</h2></div>
        <div id='snapshots-area'>
          <div id='snapshots-animframe'>
          </div>
          <div id='snapshots'>
          </div>
          <a href='#' id='snapshot-placeholder'>
            + Snapshot
          </a>
        </div>
        <menu id='snapshots-toolbar' class='horizontal-list' type='toolbar'>
          <li id='snapshots-toolbar-play'><a id='snapshots-play' href='#'>&gt; Play</a></li>
          <!-- --
          <li id='snapshots-toolbar-export' class='position-top-right'>
            <a href='#'>Export</a>
            <menu type='toolbar' class='snapshots-toolbar-pullup'>
              <li><a href='#'>PDF</a></li>
            </menu>
          </li>
          <!-- -->
        </menu>
      </div></div>
    </div></div></div>
  </div>

  <!-- Prompt IE users to install Chrome Frame. chromium.org/developers/how-tos/chrome-frame-getting-started -->
  <!--[if IE]>
    <script src="//ajax.googleapis.com/ajax/libs/chrome-frame/1.0.3/CFInstall.min.js"></script>
    <script>window.attachEvent('onload',function(){CFInstall.check({mode:'overlay'})})</script>
  <![endif]-->

  <!-- Disable text selection -->

  <script type='application/javascript'>
    var pageElement = document.getElementById('main-layout');
    pageElement.style.MozUserSelect='none';
    pageElement.onmousedown=function(){return false};
  </script>

  <!-- Framework -->

  <script src='//ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js'></script>
  <script>window.jQuery || document.write("<script src='static/lib/jquery/jquery-1.6.2.min.js'><\/script>")</script>
  <script src='//ajax.googleapis.com/ajax/libs/jqueryui/1.8.15/jquery-ui.min.js'></script>
  <script>window.jQuery.ui || document.write("<script src='static/lib/jquery/jquery-ui-1.8.15.custom.min.js'><\/script>")</script>
  <script src='static/lib/scenejs-2.0.0.0/scenejs.math.js'></script>
  <script src='static/lib/scenejs-2.0.0.0/scenejs.math.extra.js'></script>
  <!-- DEVELOPMENT -->
  <script src='static/lib/scenejs-2.0.0.0/scenejs.js'></script>
  <!-- PRODUCTION --
  <script src='static/lib/scenejs-2.0.0.0/scenejs.min.js'></script>
  <!-- -->
  
  <!-- Resources -->

  <!-- --
  <script src='static/models/Vogel_Gesamt.js'></script>
  <!-- --
  <script src='static/models/WallOnly.js'></script>
  <!-- --
  <script src='static/models/urban.js'></script>
  <!-- -->

  <!-- Application logic -->

  <!-- DEVELOPMENT -->
  <script src='static/lib/app.js'></script>
  <!-- PRODUCTION --
  <script src='static/lib/app.min.js'></script>
  <!-- -->
</body>
</html>