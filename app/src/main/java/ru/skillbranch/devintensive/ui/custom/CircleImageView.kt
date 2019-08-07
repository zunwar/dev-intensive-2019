package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import androidx.annotation.Dimension
import ru.skillbranch.devintensive.R
import android.graphics.*
import android.graphics.Bitmap
import android.util.DisplayMetrics
import androidx.annotation.ColorRes
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.core.graphics.drawable.toBitmap


class CircleImageView  @JvmOverloads constructor  (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr:Int = 0
) : ImageView(context, attrs, defStyleAttr) {


    companion object {
        private const val DEFAULT_BORDER_COLOR = Color.WHITE
        private const val DEFAULT_BORDER_WIDTH = 2
    }

    private var border_color :Int = DEFAULT_BORDER_COLOR
    private var border_width = DEFAULT_BORDER_WIDTH

    val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG)
   var Rad : Float = 0f
   var RRad : Float = 0f


    init {
        if (attrs != null ) {
           val  a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
            border_color  = a.getColor(R.styleable.CircleImageView_cv_borderColor, DEFAULT_BORDER_COLOR)
            border_width = a.getDimensionPixelSize(R.styleable.CircleImageView_cv_borderWidth, DEFAULT_BORDER_WIDTH)
//            border_color = a.getResourceId(R.styleable.CircleImageView_cv_borderColor, DEFAULT_BORDER_COLOR)
            val bit: Bitmap = drawable.toBitmap()
////************************************************************************************************************************************************
//
////            val sz = width
////            val sz :Int = TypedValue.TYPE_DIMENSION.
////              val w = width
////              val h = height
////            val sz = resources.getDimension(drawable.get)
//            h = drawable.intrinsicHeight
//            val w = drawable.intrinsicWidth
//            te = drawable.bounds
//
//
////            val iv :ImageView  = drawable.
////            val twelveDp = TypedValue.applyDimension(
////                TypedValue.COMPLEX_UNIT_DIP, 12f,
////                mContext.getResources().getDisplayMetrics()
////            )
//
//
//            val drR = RoundedBitmapDrawableFactory.create(resources, bit)
//            if (h <= w) drR.cornerRadius = h.toFloat() / 2
//            else drR.cornerRadius = w.toFloat() / 2
//
////            drR.apply {
////                cornerRadius = 400f}
////            setImageDrawable(drR)
////            var cnv : Canvas
////            cnv.drawBitmap(drR)
//
////            if(border_color == DEFAULT_BORDER_COLOR) setBorderColor( R.color.color_white)
////            else setBorderColor(hex = border_color.toString())
//
////            val b = get
////            val b = getDrawable().current
////            val c = ContextCompat.getDrawable(context , R.drawable.avatar_default)
////            val b = a.getResourceId(R.styleable.CircleImageView_src, -1)
////            a.getDrawable()
////            var b = a.resources
////            drav()
//
//            //=========================
//
//            val cnv: Canvas = Canvas()
//            val paint = Paint()
//
//
//            val bitmap: Bitmap = Bitmap.createBitmap(2000, 2000, Bitmap.Config.ARGB_8888)
//            val gg = drR.toBitmap(2000, 2000, Bitmap.Config.ARGB_8888)
//            val cvs2: Canvas = Canvas(gg)
//            val cvs1: Canvas = Canvas(gg)
//
//
//            var color: Int = Color.RED
//            val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG)
//            val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG)
//
//            fillPaint.color = color
//            strokePaint.color = color
//            strokePaint.style = Paint.Style.STROKE
//            strokePaint.strokeWidth = 20f
////        fillPaint.alpha = alpha.roundToInt()
////        strokePaint.alpha = alpha.roundToInt()
//
////        cnv.drawRect(Rect(0,0,2400,1600) , fillPaint)
////        cvs2.drawRect(Rect(0,0,2400,2400) , fillPaint)
////        cvs2.drawCircle(te.exactCenterX(), te.exactCenterY() ,  50f, fillPaint)
//
////            val rad = (te.top-te.bottom)/2.toFloat()
////            drawable.getHotspotBounds(this)
////            val xx = imageV.height
////            val yy = this.y
////            val rad = xx*1000.toFloat()
//
////            val testrect  = Rect()
////            val aaa = imageV.getDrawingRect(testrect)
////            val cc: IntArray = intArrayOf(0,0)
//
////           val rr = imageV.getLocationOnScreen(cc)
//
//
////            val bbb = imageV.x
////            +h.toFloat()/4
//
////            val ii = a.getDimensionPixelSize( height, 0)
//            val pp = imageV.drawable.intrinsicHeight
//            val dd = imageV.drawable.intrinsicWidth
//            val hh = drR.bounds
////            val jj: Int = a.getDimensionPixelSize(imageV.id, 0)
//
//            cvs1.drawCircle(hh.exactCenterX() + 1000, hh.exactCenterY() + 1000, pp.toFloat() / 5, fillPaint)
//
//
////            +500
////            cvs2.drawCircle(te.exactCenterX(),  te.exactCenterY() ,  pp.toFloat()/2, fillPaint)
//
//            val ll = round(pp*context.resources.displayMetrics.density/context.resources.displayMetrics.densityDpi)
////            val ll = round(pp*context.resources.displayMetrics.density/context.resources.displayMetrics.densityDpi)
//            val kk = round(pp*160f/context.resources.displayMetrics.densityDpi)
//            val zz = imageV.measuredHeight
//            val xx = imageV.measuredWidth
//            Log.d("M_CircleImageView", ll.toString())
//            Log.d("M_CircleImageView", pp.toString())
//            Log.d("M_CircleImageView", dd.toString())
//            Log.d("M_CircleImageView", kk.toString())
//            Log.d("M_CircleImageView", zz.toString())
//            Log.d("M_CircleImageView", xx.toString())
//
//            if (pp == 2835) {
//                cvs2.drawCircle(te.exactCenterX() + 1000, te.exactCenterY() + 1000, pp.toFloat() / 3, strokePaint)
//            } else {
//                fillPaint.color = Color.GREEN
//                cvs2.drawCircle(te.exactCenterX(), te.exactCenterY(), 2000f, fillPaint)
//            }
////            cvs2.drawCircle(te.exactCenterX(),  te.exactCenterY() ,  2000f, fillPaint)
////            setImageDrawable(drR)
////            setImageBitmap(drR.toBitmap())
////            setImageBitmap(bitmap)
//            setImageBitmap(gg)
//
////************************************************************************************************************************************************


            /**
             * This method converts dp unit to equivalent pixels, depending on device density.
             *
             * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
             * @param context Context to get resources and device specific display metrics
             * @return A float value to represent px equivalent to dp depending on device density
             */
//            public static float convertDpToPixel(float dp, Context context){
//                return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
//            }

            /**
             * This method converts device specific pixels to density independent pixels.
             *
             * @param px A value in px (pixels) unit. Which we need to convert into db
             * @param context Context to get resources and device specific display metrics
             * @return A float value to represent dp equivalent to px value
             */
//            public static float convertPixelsToDp(float px, Context context){
//                return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
//        }

            //===================++++++++++++++++++++++++++++++++++=============================================================================
//            val bit: Bitmap = drawable.toBitmap()
//
//            h = drawable.intrinsicHeight
//            val w = drawable.intrinsicWidth
//            te = drawable.bounds
//
//            val drR = RoundedBitmapDrawableFactory.create(resources, bit)
//            if (h <= w) drR.cornerRadius = h.toFloat() / 2
//            else drR.cornerRadius = w.toFloat() / 2
//
//
//            val cnv: Canvas = Canvas()
//            val paint = Paint()
//
//
//            val bitmap: Bitmap = Bitmap.createBitmap(2000, 2000, Bitmap.Config.ARGB_8888)
//            val gg = drR.toBitmap(2000, 2000, Bitmap.Config.ARGB_8888)
//            val cvs2: Canvas = Canvas(gg)
//            val cvs1: Canvas = Canvas(gg)
//
//
//            var color: Int = Color.RED
//            val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG)
//            val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG)
//
//            fillPaint.color = color
//            strokePaint.color = color
//            strokePaint.style = Paint.Style.STROKE
//            strokePaint.strokeWidth = 20f
//
//            val pp = imageV.drawable.intrinsicHeight
//            val dd = imageV.drawable.intrinsicWidth
//            val hh = drR.bounds
//
//
//            cvs1.drawCircle(hh.exactCenterX() + 1000, hh.exactCenterY() + 1000, pp.toFloat() / 5, fillPaint)
//
//
//            val ll = round(pp*context.resources.displayMetrics.density/context.resources.displayMetrics.densityDpi)
//            val kk = round(pp*160f/context.resources.displayMetrics.densityDpi)
//            val zz = imageV.measuredHeight
//            val xx = imageV.measuredWidth
//            Log.d("M_CircleImageView", ll.toString())
//            Log.d("M_CircleImageView", pp.toString())
//            Log.d("M_CircleImageView", dd.toString())
//            Log.d("M_CircleImageView", kk.toString())
//            Log.d("M_CircleImageView", zz.toString())
//            Log.d("M_CircleImageView", xx.toString())
//
//            if (pp == 2835) {
//                cvs2.drawCircle(te.exactCenterX() + 1000, te.exactCenterY() + 1000, pp.toFloat() / 3, strokePaint)
//            } else {
//                fillPaint.color = Color.GREEN
//                cvs2.drawCircle(te.exactCenterX(), te.exactCenterY(), 2000f, fillPaint)
//            }
////            cvs2.drawCircle(te.exactCenterX(),  te.exactCenterY() ,  2000f, fillPaint)
////            setImageDrawable(drR)
////            setImageBitmap(drR.toBitmap())
////            setImageBitmap(bitmap)
//            setImageBitmap(gg)

//=======++++++++++++++++++++++++++++++============================++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


//            setBorderColor(hex = border_color.toString())
//            Log.d("M_CircleImageView","uco--------------------------------------------------==========================")
//            Log.d("M_CircleImageView",border_color.toString())
//            Log.d("M_CircleImageView","uco")
//            Log.d("M_CircleImageView", border_width.toString())

            strokePaint.strokeWidth = border_width.toFloat()

//            //переводим полученные пиксели в дп
//            border_width = border_width*DisplayMetrics.DENSITY_DEFAULT/context.resources.displayMetrics.densityDpi
//
//            Log.d("M_CircleImageView","uco")
//            Log.d("M_CircleImageView", border_width.toString())

//            Color.parseColor(border_color.toString())

//            if ( border_color.toChar().isDigit()) {
//                Log.d("M_CircleImageView","uco++++++++++++++++++++++++++++++++++++====================")
//                setBorderColor(colorId = attrs.getIdAttributeResourceValue(border_color))
//            } else {
//                Log.d("M_CircleImageView","uco--------------------------------------------------==========================")
//                Log.d("M_CircleImageView",border_color.toString())
//                setBorderColor(hex=border_color.toString())
//            }


//            "@color/color_primary_dark"

            a.recycle()


        }
    }

    fun getBorderWidth():Int {
    return border_width
    }

    fun setBorderWidth(@Dimension dp:Int){

        //конвертнуть из дп в пиксели и потом сделать границу
        val px = dp * context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT

        border_width = px
        strokePaint.strokeWidth = border_width.toFloat()

    }
    fun getBorderColor():Int {
        return border_color
    }
    fun setBorderColor(hex:String) {

        border_color = Color.parseColor(hex)
    }
    fun setBorderColor(@ColorRes colorId: Int) {
        border_color=colorId
    }

 var tt =1
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (tt==1){
            risovanie()
            tt++
        }


    }
///============================================================================

    fun risovanie() {
        val hh = measuredHeight
        val ww = measuredWidth
//        Log.d("M_CircleImageView","measuredHeight")
//        Log.d("M_CircleImageView", hh.toString())
//        Log.d("M_CircleImageView","measuredWidth")
//        Log.d("M_CircleImageView", ww.toString())


//bb это количество dp
//        val bb = hh / (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
        val bit: Bitmap = drawable.toBitmap()

        val h = drawable.intrinsicHeight
        val w = drawable.intrinsicWidth
        val te = drawable.bounds

        //bb это количество dp
//        val bb = hh / (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)

        //считаем коэф, чтобы размеры с картинки и на экране соответствовали
        if (h<=w) Rad=h/2.toFloat()
        else  Rad=w/2.toFloat()
        if (hh<=ww) RRad=hh/2.toFloat()
        else  RRad=ww/2.toFloat()
        val kof = Rad/RRad
        strokePaint.strokeWidth=strokePaint.strokeWidth*kof

//        Log.d("M_CircleImageView","kof")
//        Log.d("M_CircleImageView", kof.toString())
//        Log.d("M_CircleImageView", strokePaint.strokeWidth.toString())


//        Log.d("M_CircleImageView","intrinsicHeight")
//        Log.d("M_CircleImageView", h.toString())
//        Log.d("M_CircleImageView","intrinsicWidth")
//        Log.d("M_CircleImageView", w.toString())

        val drR = RoundedBitmapDrawableFactory.create(resources, bit)
        if (h <= w) drR.cornerRadius = h.toFloat() / 2
        else drR.cornerRadius = w.toFloat() / 2

//        val bitmap: Bitmap = Bitmap.createBitmap(2000, 2000, Bitmap.Config.ARGB_8888)
        val gg = drR.toBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val cvs2: Canvas = Canvas(gg)
//        val cvs1: Canvas = Canvas(gg)


        val color: Int = border_color
        val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG)
//        val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG)

        fillPaint.color = color
        strokePaint.color = color
        strokePaint.style = Paint.Style.STROKE
//        strokePaint.strokeWidth = border_width
        val mm = strokePaint.strokeWidth/2
//
//        Log.d("M_CircleImageView","uco")
//        Log.d("M_CircleImageView", strokePaint.strokeWidth.toString())



//        cvs1.drawCircle(te.exactCenterX() , te.exactCenterY() , 150f, fillPaint)

//        if (pp > 0 ) {
            cvs2.drawCircle(te.exactCenterX() , te.exactCenterY() , h/2.toFloat()-mm, strokePaint)
//        }
//        else {
//            fillPaint.color = Color.GREEN
//            cvs2.drawCircle(te.exactCenterX(), te.exactCenterY(), 2000f, fillPaint)
//        }
//        val cvs3: Canvas = Canvas(gg)
//        fillPaint.color = Color.GREEN
//
//        val strokePaint2 = Paint(Paint.ANTI_ALIAS_FLAG)
//        strokePaint2.color = Color.GREEN
//        strokePaint2.style = Paint.Style.STROKE
//
//        cvs3.drawCircle(te.exactCenterX() , te.exactCenterY() , 66f, fillPaint)

        setImageBitmap(gg)

    }



//    fun drav () {
//val bitmap: Bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ARGB_8888)
//    val canvas: Canvas = Canvas(bitmap)
//
//   lateinit  var shapeDrawable: ShapeDrawable
//
//    // rectangle positions
//    var left =   0
//    var top=    0
//    var right=  800
//    var bottom = 1600
//
//    // draw rectangle shape to canvas
//    shapeDrawable = ShapeDrawable(RectShape())
//    shapeDrawable.setBounds( left, top, right, bottom)
//        shapeDrawable.paint.color = Color.parseColor("#009944")
//    shapeDrawable.draw(canvas)
////    shapeDrawable.setVisible(true, true)
////    shapeDrawable.level = 10000
//
//
////    // oval positions
////    left = 100
////    top = 500
////    right = 600
////    bottom = 800
////
////    // draw oval shape to canvas
////    shapeDrawable = ShapeDrawable(OvalShape())
////    shapeDrawable.setBounds( left, top, right, bottom)
////    shapeDrawable.getPaint().setColor(Color.parseColor("#009191"))
////    shapeDrawable.draw(canvas)
//
//    // now bitmap holds the updated pixels
//
//    // set bitmap as background to ImageView
//
//    imageV.background = BitmapDrawable(getResources(), bitmap)
//
//    }

}