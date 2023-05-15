<ol dir="auto">
<li>
<p dir="auto">Include the library as local library project:</p>
<div class="highlight highlight-source-groovy notranslate position-relative overflow-auto" dir="auto">
<pre><code id="depCodeGradle" class=" kode  language-css">maven <span class="token string">{url 'https://jitpack.io'}</span></code><span class="pl-s"><span class="pl-pds"><br /><br /></span></span></pre>
</div>
</li>
<li>
<p dir="auto">Include the library as local library project:</p>
<div class="highlight highlight-source-groovy notranslate position-relative overflow-auto" dir="auto">
<pre><code id="depCodeGradle" class=" kode  language-css">implementation <span class="token string">'com.github.smartandroidcourse:DayNightSwitch:1.0</span></code><span class="pl-s"><span class="pl-pds">'<br /><br /></span></span></pre>
</div>
</li>
<li>
<p dir="auto">Add view to your layout file:</p>
<div class="highlight highlight-text-xml notranslate position-relative overflow-auto" dir="auto">
<pre><span class="pl-c"><span class="pl-c">&lt;!--</span> ... <span class="pl-c">--&gt;</span></span></pre>
<pre>&lt;?xml version="1.0" encoding="utf-8"?&gt;<br />&lt;FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"<br />    android:layout_width="match_parent"<br />    android:layout_height="match_parent"<br />    android:background="@android:color/white"&gt;<br /><br />    &lt;View<br />        android:id="@+id/background_view"<br />        android:layout_width="match_parent"<br />        android:layout_height="match_parent"<br />        android:background="@android:color/black"<br />        android:alpha="0"/&gt;<br /><br />    &lt;colorsfx.smart.android.courses.daynightswitch.DayNightSwitch<br />        android:id="@+id/day_night_switch"<br />        android:layout_width="76dp"<br />        android:layout_height="40dp"<br />        android:layout_gravity="center"/&gt;<br /><br />&lt;/FrameLayout&gt;</pre>
<pre><span class="pl-c"><span class="pl-c">&lt;!--</span> ... <span class="pl-c">--&gt;</span></span></pre>
<div class="zeroclipboard-container position-absolute right-0 top-0">&nbsp;</div>
</div>
</li>
<li>
<p dir="auto">Add component handler into your activity or fragment (<strong>Java</strong>):</p>
<div class="highlight highlight-source-java notranslate position-relative overflow-auto" dir="auto">
<pre>public class MainActivity extends AppCompatActivity {<br /><br />    private DayNightSwitch day_night_switch;<br />    public static final String TAG = "MainActivity";<br /><br />    @Override<br />    protected void onCreate(Bundle savedInstanceState) {<br />        super.onCreate(savedInstanceState);<br />        setContentView(R.layout.activity_main);<br /><br />        final View background_view = findViewById(R.id.background_view);<br /><br />        day_night_switch = (DayNightSwitch)findViewById(R.id.day_night_switch);<br />        day_night_switch.setDuration(450);<br /><br />        day_night_switch.setListener(new DayNightSwitchListener() {<br />            @Override<br />            public void onSwitch(boolean is_night) {<br />                Log.d(TAG, "onSwitch() called with: is_night = [" + is_night + "]");<br />                if (is_night)<br />                    background_view.setAlpha(1f);<br /><br />            }<br />        });<br /><br />        day_night_switch.setAnimListener(new DayNightSwitchAnimListener() {<br />            @Override<br />            public void onAnimStart() {<br />                Log.d(TAG, "onAnimStart() called");<br />            }<br /><br />            @Override<br />            public void onAnimEnd() {<br />                Log.d(TAG, "onAnimEnd() called");<br />            }<br /><br />            @Override<br />            public void onAnimValueChanged(float value) {<br />                background_view.setAlpha(value);<br />                Log.d(TAG, "onAnimValueChanged() called with: value = [" + value + "]");<br />            }<br />        });<br /><br />    }<br /><br /><br />}</pre>
<div class="zeroclipboard-container position-absolute right-0 top-0">&nbsp;</div>
</div>
</li>
<li>
<p dir="auto">Add component handler into your activity or fragment (<strong>Kotlin</strong>):</p>
<div class="highlight highlight-source-java notranslate position-relative overflow-auto" dir="auto">
<pre>class MainActivity : AppCompatActivity() {<br /><br />    lateinit var day_night_switch: DayNightSwitch<br />    val TAG = "MainActivity"<br /><br />    override fun onCreate(savedInstanceState: Bundle?) {<br />        super.onCreate(savedInstanceState)<br />        setContentView(R.layout.activity_main)<br /><br />        val background_view = findViewById&lt;View&gt;(R.id.background_view)<br /><br />        day_night_switch = findViewById&lt;View&gt;(R.id.day_night_switch) as DayNightSwitch<br />        day_night_switch.setDuration(450)<br /><br />        day_night_switch.setListener { is_night -&gt;<br />            Log.d(TAG, "onSwitch() called with: is_night = [$is_night]")<br />            if (is_night) background_view.alpha = 1f<br />        }<br /><br />        day_night_switch.setAnimListener(object : DayNightSwitchAnimListener {<br />            override fun onAnimStart() {<br />                Log.d(TAG, "onAnimStart() called")<br />            }<br /><br />            override fun onAnimEnd() {<br />                Log.d(TAG, "onAnimEnd() called")<br />            }<br /><br />            override fun onAnimValueChanged(value: Float) {<br />                background_view.alpha = value<br />                Log.d(TAG, "onAnimValueChanged() called with: value = [$value]")<br />            }<br />        })<br /><br /><br />    }<br /><br />    }<br /><br /></pre>
<div class="zeroclipboard-container position-absolute right-0 top-0">&nbsp;</div>
</div>
</li>
</ol>
