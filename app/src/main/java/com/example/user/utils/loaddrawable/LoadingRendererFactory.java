package com.example.user.utils.loaddrawable;

import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import com.example.user.utils.loaddrawable.circle.jump.CollisionLoadingRenderer;
import com.example.user.utils.loaddrawable.circle.jump.DanceLoadingRenderer;
import com.example.user.utils.loaddrawable.circle.jump.GuardLoadingRenderer;
import com.example.user.utils.loaddrawable.circle.jump.SwapLoadingRenderer;
import com.example.user.utils.loaddrawable.circle.rotate.GearLoadingRenderer;
import com.example.user.utils.loaddrawable.circle.rotate.LevelLoadingRenderer;
import com.example.user.utils.loaddrawable.circle.rotate.MaterialLoadingRenderer;
import com.example.user.utils.loaddrawable.circle.rotate.WhorlLoadingRenderer;
import com.example.user.utils.loaddrawable.goods.BalloonLoadingRenderer;
import com.example.user.utils.loaddrawable.goods.WaterBottleLoadingRenderer;
import com.example.user.utils.loaddrawable.scenery.DayNightLoadingRenderer;
import com.example.user.utils.loaddrawable.scenery.ElectricFanLoadingRenderer;

/**
 * 动画加载工厂
 */

public final class LoadingRendererFactory {

    private static final SparseArray<Class<? extends LoadingRenderer>> LOADING_RENDERERS = new SparseArray<>();

    static {
        //circle rotate
        LOADING_RENDERERS.put(0, MaterialLoadingRenderer.class);
        LOADING_RENDERERS.put(1, LevelLoadingRenderer.class);
        LOADING_RENDERERS.put(2, WhorlLoadingRenderer.class);
        LOADING_RENDERERS.put(3, GearLoadingRenderer.class);
        //circle jump
        LOADING_RENDERERS.put(4, SwapLoadingRenderer.class);
        LOADING_RENDERERS.put(5, GuardLoadingRenderer.class);
        LOADING_RENDERERS.put(6, DanceLoadingRenderer.class);
        LOADING_RENDERERS.put(7, CollisionLoadingRenderer.class);
        //scenery
        LOADING_RENDERERS.put(8, DayNightLoadingRenderer.class);
        LOADING_RENDERERS.put(9, ElectricFanLoadingRenderer.class);
        //goods
        LOADING_RENDERERS.put(10, BalloonLoadingRenderer.class);
        LOADING_RENDERERS.put(11, WaterBottleLoadingRenderer.class);
    }

    private LoadingRendererFactory() {
    }

    public static LoadingRenderer createLoadingRenderer(Context context, int loadingRendererId) throws Exception {
        Class<?> loadingRendererClazz = LOADING_RENDERERS.get(loadingRendererId);
        Constructor<?>[] constructors = loadingRendererClazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes != null
                    && parameterTypes.length == 1
                    && parameterTypes[0].equals(Context.class)) {
                constructor.setAccessible(true);
                return (LoadingRenderer) constructor.newInstance(context);
            }
        }

        throw new InstantiationException();
    }
}
