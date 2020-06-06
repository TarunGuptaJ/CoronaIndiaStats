package com.androiddevs.confused.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\'\u0010/\u001a\u0004\u0018\u00010\u00022\u0016\u00100\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000201\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u00102J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0002H\u0015R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u0005\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\nR\u001a\u0010\"\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001a\u0010%\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b\'\u0010\u001cR\u001a\u0010(\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u0011\u0010+\u001a\u00020,\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.\u00a8\u00066"}, d2 = {"Lcom/androiddevs/confused/ui/fragments/stateTest;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "()V", "allStates", "", "Lcom/androiddevs/confused/ui/State;", "getAllStates", "()Ljava/util/List;", "setAllStates", "(Ljava/util/List;)V", "api", "Lcom/androiddevs/confused/ui/Api;", "getApi", "()Lcom/androiddevs/confused/ui/Api;", "setApi", "(Lcom/androiddevs/confused/ui/Api;)V", "call", "Lretrofit2/Call;", "getCall", "()Lretrofit2/Call;", "setCall", "(Lretrofit2/Call;)V", "displayText", "", "getDisplayText", "()Ljava/lang/String;", "setDisplayText", "(Ljava/lang/String;)V", "districts", "", "Lcom/androiddevs/confused/ui/districtData;", "getDistricts", "setDistricts", "finalParsed", "getFinalParsed", "setFinalParsed", "json", "getJson", "setJson", "singleParsed", "getSingleParsed", "setSingleParsed", "url", "Ljava/net/URL;", "getUrl", "()Ljava/net/URL;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "onPostExecute", "", "result", "app_debug"})
final class stateTest extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String displayText = "";
    @org.jetbrains.annotations.NotNull()
    public java.lang.String singleParsed;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String finalParsed = "";
    @org.jetbrains.annotations.NotNull()
    public java.lang.String json;
    @org.jetbrains.annotations.NotNull()
    private final java.net.URL url = null;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.util.List<com.androiddevs.confused.ui.districtData>> districts;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.androiddevs.confused.ui.State> allStates;
    @org.jetbrains.annotations.Nullable()
    private com.androiddevs.confused.ui.Api api;
    @org.jetbrains.annotations.Nullable()
    private retrofit2.Call<java.util.List<com.androiddevs.confused.ui.State>> call;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDisplayText() {
        return null;
    }
    
    public final void setDisplayText(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSingleParsed() {
        return null;
    }
    
    public final void setSingleParsed(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFinalParsed() {
        return null;
    }
    
    public final void setFinalParsed(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJson() {
        return null;
    }
    
    public final void setJson(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.net.URL getUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.util.List<com.androiddevs.confused.ui.districtData>> getDistricts() {
        return null;
    }
    
    public final void setDistricts(@org.jetbrains.annotations.Nullable()
    java.util.List<java.util.List<com.androiddevs.confused.ui.districtData>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.androiddevs.confused.ui.State> getAllStates() {
        return null;
    }
    
    public final void setAllStates(@org.jetbrains.annotations.Nullable()
    java.util.List<com.androiddevs.confused.ui.State> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.androiddevs.confused.ui.Api getApi() {
        return null;
    }
    
    public final void setApi(@org.jetbrains.annotations.Nullable()
    com.androiddevs.confused.ui.Api p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final retrofit2.Call<java.util.List<com.androiddevs.confused.ui.State>> getCall() {
        return null;
    }
    
    public final void setCall(@org.jetbrains.annotations.Nullable()
    retrofit2.Call<java.util.List<com.androiddevs.confused.ui.State>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Void doInBackground(@org.jetbrains.annotations.NotNull()
    java.lang.Void... params) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    protected void onPostExecute(@org.jetbrains.annotations.Nullable()
    java.lang.Void result) {
    }
    
    public stateTest() {
        super();
    }
}